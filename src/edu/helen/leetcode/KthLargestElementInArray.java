package edu.helen.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * https://stomachache007.wordpress.com/2017/04/02/%E4%B9%9D%E7%AB%A0%E7%AE%97%E6%B3%95%E7%AC%94%E8%AE%B0-7-%E4%B8%A4%E6%A0%B9%E6%8C%87%E9%92%88-two-pointers-3/
 * https://discuss.leetcode.com/topic/14597/solution-explained
 * https://discuss.leetcode.com/topic/18662/ac-clean-quickselect-java-solution-avg-o-n-time?page=1
 * Created by Helen on 12/24/2017.
 */
public class KthLargestElementInArray {
    /*
    * @param k an integer
    * @param nums an integer array
    * @return kth smallest element
    */
    public int kthSmallest(int k, int[] nums) {
        // write your code here
        return quickSelect2(nums, 0, nums.length - 1, k - 1);
    }

    public int quickSelect2(int[] A, int start, int end , int k) {

        if (start == end)
            return A[start];

        int left = start, right = end;
        int pivot = A[(start + end) / 2];

        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }

            while (left <= right && A[right] > pivot) {
                right--;
            }
            if (left <= right) {
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;

                left++;
                right--;
            }
        }

        if (right >= k && start <= right)
            return quickSelect2(A, start, right, k);
        else if (left <= k && left <= end)
            return quickSelect2(A, left, end, k);
        else
            return A[k];
    }

    //O(N) best case / O(N^2) worst case running time + O(1) memory
    public int findKthLargest(int[] nums, int k) {
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

    /**
             T(n)  = T(2/n)  + O(n)
            所以时间复杂度为:  n + n/2 + … + 1 ~2n
             所以时间复杂度为O(n)
    * @param k : description of k
    * @param nums : array of nums
    * @return: description of return
    */
    public int kthLargestElement(int k, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        return helper(nums, 0, nums.length - 1, nums.length - k + 1);

    }
    public int helper(int[] nums, int l, int r, int k) {
        if (l == r) {
            return nums[l];
        }
        int position = partition(nums, l, r);
        if (position + 1 == k) {
            return nums[position];
        } else if (position + 1 < k) {
            return helper(nums, position + 1, r, k);
        }  else {
            return helper(nums, l, position - 1, k);
        }
    }
    public int partition(int[] nums, int l, int r) {
        // 初始化左右指针和pivot
        int left = l, right = r;
        int pivot = nums[left];

        // 进行partition
        while (left < right) {
            while (left < right && nums[right] >= pivot) {
                right--;
            }
            nums[left] = nums[right];
            while (left < right && nums[left] <= pivot) {
                left++;
            }
            nums[right] = nums[left];
        }

        // 返还pivot点到数组里面
        nums[left] = pivot;
        return left;
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
        ke.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }
}
