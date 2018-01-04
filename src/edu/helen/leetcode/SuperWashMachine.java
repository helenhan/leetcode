package edu.helen.leetcode;

/**
 * https://leetcode.com/problems/super-washing-machines/discuss/99185/
 * Created by Helen on 11/21/2017.
 */
public class SuperWashMachine {
    public int findMinMoves(int[] machines) {
        int cnt = 0, total = 0;
        for (int i : machines) {
            total += i;
        }
        if (total % machines.length != 0) return -1;
        int avg = total / machines.length;
        int res = 0;
        for (int load : machines) {
            cnt = cnt + (load - avg);
            res = Math.max(Math.max(res, Math.abs(cnt)), load - avg); // do not forget Math.abs(cnt) not cnt directly.
        }
        return res;
    }
}

