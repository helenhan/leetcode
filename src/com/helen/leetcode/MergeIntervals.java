package com.helen.leetcode;

import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/**
 *
 * https://leetcode.com/problems/merge-intervals/discuss/21222/A-simple-Java-solution
 * Created by Helen on 2/28/2018.
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return intervals;
        }
        Collections.sort(intervals, (a, b) -> (a.start - b.start));
        ListIterator<Interval> iter = intervals.listIterator();
        Interval cur = iter.next();
        while (iter.hasNext()) {
            Interval next = iter.next();
            if (cur.end < next.start) {
                cur = next;
                continue;
            } else {
                cur.end = Math.max(cur.end, next.end);
                iter.remove();
            }
        }
        return intervals;
    }
}
