package edu.helen.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 这题有两种解法，自顶向下以及自底向上。+

 根据题目我们知道，每向下一层，我们只能选择邻接数字进行累加，譬如上面第1行的数字3，它的下一行邻接数字就是6和5。
 区别于自顶向下，另一种更简单的做法就是自底向上了。dp方程为
 dp[m][n] = min(dp[m + 1][n], dp[m + 1][n + 1]) + triangle[m][n]

 https://leetcode.com/problems/triangle/discuss/38730/
 * Created by Helen on 1/6/2018.
 */
public class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0 || triangle.get(0).size() == 0) {
            return 0;
        }
        int row = triangle.size();
        int[] dp = new int[triangle.get(row - 1).size()]; //the number of digits in last row equals the number of rows.
        int k = 0;
        for (int num : triangle.get(row - 1)) {
            dp[k++] = num;
        }
        for (int i = row - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[j] = Math.min(dp[j], dp[j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        Triangle t = new Triangle();
        List<List<Integer>> triangle = new LinkedList<>();
        List<Integer> row0 = new LinkedList<>();
        row0.add(2);
        List<Integer> row1 = new LinkedList<>();
        row1.add(3);
        row1.add(4);
        List<Integer> row2 = new LinkedList<>();
        row2.add(5);
        row2.add(6);
        row2.add(7);
        List<Integer> row3 = new LinkedList<>();
        row3.add(4);
        row3.add(1);
        row3.add(8);
        row3.add(3);
        triangle.add(row0);
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        t.minimumTotal(triangle);
    }
}
