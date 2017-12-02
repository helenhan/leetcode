package edu.helen.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Created by Helen on 10/19/2017.
 */
public class ThirdMax {


    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3))
                continue;

            if (max1 == null || n > max1) {
                max3 = max2; //The giving value order here can not be changed.
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }

    /**
     * 下面这种方法的时间复杂度是O(nlgn)，不符合题目要求，纯粹是拓宽下思路哈，
     * 利用了set的自动排序和自动去重复项的特性，很好的解决了问题，对于遍历到的数字，加入set中，重复项就自动去掉了，
     * 如果此时set大小大于3个了，那么我们把set的第一个元素去掉，也就是将第四大的数字去掉，
     * 那么就可以看出set始终维护的是最大的三个不同的数字，最后遍历结束后，我们看set的大小是否为3，是的话就返回首元素，不是的话就返回尾元素，参见代码如下：
     *
     * @param nums
     * @return
     */
    public int thirdMax2(int[] nums) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Set<Integer> set = new HashSet<>();
        for (Integer n : nums) {
            if (set.add(n)) {
                queue.offer(n);
                if (queue.size() > 3) {
                    Integer num = queue.poll();
                    set.remove(num);
                }
            }
        }
        if (queue.size() == 2) {
            queue.poll();
        }
        return queue.peek();
    }
}
