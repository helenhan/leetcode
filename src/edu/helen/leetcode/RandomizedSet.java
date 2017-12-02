package edu.helen.leetcode;

import java.util.*;

/**
 * Created by Helen on 10/18/2017.
 */
public class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;
    Random random;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(map.containsKey(val)){
            return false;
        }
        map.put(val,list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
            return false;
        }
        int loc = map.get(val);
        if(loc<list.size()-1){
            int lastone = list.get(list.size()-1);
            list.set(loc,lastone);
            map.put(lastone,loc);
        }
        map.remove(val);
        list.remove(list.size()-1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
