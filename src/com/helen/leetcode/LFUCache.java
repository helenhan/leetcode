package com.helen.leetcode;

import java.util.HashMap;
import java.util.LinkedHashSet;

/**
 * solution:
 * http://www.cnblogs.com/grandyang/p/6258459.html
 * code:
 * https://leetcode.com/problems/lfu-cache/discuss/94521/?page=1
 *
 * 这道题是让我们实现最近不常用页面置换算法LFU (Least Frequently Used), 之前我们做过一道类似的题LRU Cache，
 * 让我们求最近最少使用页面置换算法LRU (Least Recnetly Used)。两种算法虽然名字看起来很相似，但是其实是不同的。
 * 顾名思义，LRU算法是首先淘汰最长时间未被使用的页面，而LFU是先淘汰一定时间内被访问次数最少的页面。光说无凭，
 * 举个例子来看看，比如说我们的cache的大小为3，然后我们按顺序存入 5，4，5，4，5，7，这时候cache刚好被装满了，因为put进去之前存在的数不会占用额外地方。
 * 那么此时我们想再put进去一个8，如果使用LRU算法，应该将4删除，因为4最久未被使用，而如果使用LFU算法，则应该删除7，
 * 因为7被使用的次数最少，只使用了一次。相信这个简单的例子可以大概说明二者的区别。

 这道题比之前那道LRU的题目还要麻烦一些，因为那道题只要用个list把数字按时间顺序存入，链表底部的位置总是最久未被使用的，
 每次删除底部的值即可。而这道题不一样，由于需要删除最少次数的数字，那么我们必须要统计每一个key出现的次数，
 所以我们用一个哈希表m来记录当前数据{key, value}和其出现次数之间的映射，这样还不够，为了方便操作，
 我们需要把相同频率的key都放到一个list中，那么需要另一个哈希表freq来建立频率和一个里面所有key都是当前频率的list之间的映射。
 由于题目中要我们在O(1)的时间内完成操作了，为了快速的定位freq中key的位置，我们再用一个哈希表iter来建立key和freq中key的位置之间的映射。
 最后当然我们还需要两个变量cap和minFreq，分别来保存cache的大小，和当前最小的频率。
 * Created by Helen on 12/30/2017.
 */
public class LFUCache {
    private int min;
    private final int capacity;
    private final HashMap<Integer, Integer> keyToVal;
    private final HashMap<Integer, Integer> keyToCount;
    private final HashMap<Integer, LinkedHashSet<Integer>> countToLRUKeys;

    public LFUCache(int capacity) {
        this.min = -1;
        this.capacity = capacity;
        this.keyToVal = new HashMap<>();
        this.keyToCount = new HashMap<>();
        this.countToLRUKeys = new HashMap<>();
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        int count = keyToCount.get(key);
        countToLRUKeys.get(count).remove(key); // do not need to remove keyToCount since we override value in putToCount
        if (count == min && countToLRUKeys.get(min).size() == 0) {
            min++;
        }
        putToCount(key, count + 1);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (capacity <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            get(key); // update key's count
            return;
        }
        if (keyToVal.size() >= capacity) {
            evit(countToLRUKeys.get(min).iterator().next());
        }
        min = 1;
        putToCount(key, min);
        keyToVal.put(key, value);
    }

    private void putToCount(int key, int count) {
        keyToCount.put(key, count);
        countToLRUKeys.computeIfAbsent(count, k -> new LinkedHashSet<Integer>());
        countToLRUKeys.get(count).add(key);
    }

    private void evit(int key) {
        countToLRUKeys.get(min).remove(key);
        keyToVal.remove(key);
        keyToCount.remove(key);
    }
}
