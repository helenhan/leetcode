package edu.helen.leetcode;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * Created by Helen on 2/21/2018.
 */
public class MeetingRoomII {
    public int minMeetingRooms(Interval[] intervals) {
//        if(intervals==null||intervals.length==0){
//            return 0;
//        }
        int cnt = 0;
//        PriorityQueue<Interval[]> queue = new PriorityQueue<>((a, b) ->(a[1]-b[1]));
//        Interval[] head = queue.poll();
//        int tail = head[1];
//        for (int i = 1; i <queue.size() ; i++) {
//            int[] a = queue.poll();
//            if(a[0]>tail){
//                cnt++;
//            }
//            tail = a[1];
//        }
        return cnt;
    }

    /**
     * https://leetcode.com/problems/meeting-rooms-ii/discuss/68004/Super-easy-Java-solution-using-TreeMap
     *
     * @param intervals
     * @return
     */
    public int minMeetingRooms2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (Interval i : intervals) {
            map.put(i.start, map.getOrDefault(i.start, 0) + 1);
            map.put(i.end, map.getOrDefault(i.end, 0) - 1);
        }
        int res = 0, curr = 0;
        for (int key : map.keySet()) {
            res = Math.max(res, curr += map.get(key));
        }
        return res;
    }

    /**
     * https://leetcode.com/problems/meeting-rooms-ii/discuss/67855/Explanation-of-%22Super-Easy-Java-Solution-Beats-98.8%22-from-@pinkfloyda
     * @param intervals
     * @return
     */
    public int minMeetingRooms3(Interval[] intervals) {
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];
        for(int i=0;i<intervals.length;i++){
            start[i] = intervals[i].start;
            end[i] = intervals[i].end;
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int res =0;
        int endIdx = 0;
        for(int i=0;i<intervals.length;i++){
            if(start[i]<end[endIdx]){
                res++;
            }else{
                endIdx++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        MeetingRoomII mr = new MeetingRoomII();
        Interval i1 = new Interval(0,8);
        Interval i2 = new Interval(5,10);
        Interval i3 = new Interval(15,20);
        mr.minMeetingRooms3(new Interval[]{i1,i2,i3});
    }
}
