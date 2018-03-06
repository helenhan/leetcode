package edu.helen.leetcode;

/**
 * https://leetcode.com/problems/design-hit-counter/discuss/83483/Super-easy-design-O(1)-hit()-O(s)-getHits()-no-fancy-data-structure-is-needed!?page=1
 * O(s) s is total seconds in given time interval, in this case 300.
 basic ideal is using buckets. 1 bucket for every second because we only need to keep the recent hits info for 300 seconds.
 hit[] array is wrapped around by mod operation. Each hit bucket is associated with times[] bucket which record current time.
 If it is not current time, it means it is 300s or 600s… ago and need to reset to 1.
 * Created by Helen on 3/3/2018.
 */
public class HitCounter {
    private int[] times = new int[300];
    private int[] hits = new int[300];

    /**
     * Initialize your data structure here.
     */
    public HitCounter() {

    }

    /**
     * Record a hit.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public void hit(int timestamp) {
        int index = timestamp % 300;
        if (times[index] != timestamp) {
            times[index] = timestamp;
            hits[index] = 1;
        } else {
            hits[index]++;
        }
    }

    /**
     * Return the number of hits in the past 5 minutes.
     *
     * @param timestamp - The current timestamp (in seconds granularity).
     */
    public int getHits(int timestamp) {
        int total = 0;
        for (int i = 0; i < 300; i++) {
            if (timestamp - times[i] < 300) {
                total += hits[i];
            }
        }
        return total;
    }
}
