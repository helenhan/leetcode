package edu.helen.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * http://www.cnblogs.com/grandyang/p/4539757.html
 * https://stomachache007.wordpress.com/2017/04/02/%E4%B9%9D%E7%AB%A0%E7%AE%97%E6%B3%95%E7%AC%94%E8%AE%B0-7-%E4%B8%A4%E6%A0%B9%E6%8C%87%E9%92%88-two-pointers-3/
 * https://discuss.leetcode.com/topic/14597/solution-explained
 * https://discuss.leetcode.com/topic/18662/ac-clean-quickselect-java-solution-avg-o-n-time?page=1
 * Created by Helen on 12/24/2017.
 */
public class KthLargestElementInArray {
    public int findKthLargest(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int lo = 0;
        int high = nums.length - 1;
        while (true) {
            int m = partition(nums, lo, high);
            if (m == k - 1) {
                return nums[m];
            } else if (m > k - 1) {
                high = m - 1;
            } else {
                lo = m + 1;
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int l = left + 1; // old is used as pivot, so no need to calculate it;
        int r = right;
        while (l <= r) {
            if (nums[l] < pivot && nums[r] > pivot) {
                swap(nums, l++, r--);
            }
            if (nums[l] >= pivot) l++;
            if (nums[r] <= pivot) r--;
        }
        swap(nums, left, r);
        return r;
    }

    //O(N) best case / O(N^2) worst case running time + O(1) memory
    public int findKthLargest1(int[] nums, int k) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n - 1, n - k + 1); //notcie return index of kth largest number not value
        return nums[p];
    }

    // return the index of the kth smallest number
    private int quickSelect(int[] nums, int lo, int hi, int k) {
        // use quick sort's idea
        // put nums that are <= pivot to the left
        // put nums that are  > pivot to the right
        int pivot = nums[hi];
        int i = lo, j = hi;
        while (i < j) {
            if (nums[i++] > pivot) {
                swap(nums, --i, --j);//must be --i and --j, because i has incremented already in last step.
            }
        }
        swap(nums, i, hi); // do not forget this step
        // count the nums that are <= pivot from lo
        int m = i - lo + 1;
        // pivot is the one!
        if (m == k) {
            return i;
        } else if (m > k) {
            // pivot is too big, so it must be on the left
            return quickSelect(nums, lo, i - 1, k);
        } else {
            // pivot is too small, so it must be on the right
            return quickSelect(nums, i + 1, hi, k - m);
        }
    }

    private void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }


    // O(nlogn)
    public int findKthLargest2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k]; //Note index is length-k
    }

    //O(N lg K) running time + O(K) memory
    public int findKthLargest3(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            queue.offer(nums[i]);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        return queue.peek();
    }


    public static void main(String[] args) {
        KthLargestElementInArray ke = new KthLargestElementInArray();
        int num = ke.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
        System.out.println(num);
    }
}
