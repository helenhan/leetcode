package edu.helen.leetcode;

/**
 * This is a typical DP problem. Suppose the minimum path sum of arriving at point (i, j) is S[i][j],
 * then the state equation is S[i][j] = min(S[i - 1][j], S[i][j - 1]) + grid[i][j].
 Well, some boundary conditions need to be handled. The boundary conditions happen
 on the topmost row (S[i - 1][j] does not exist) and the leftmost column (S[i][j - 1] does not exist).
 Suppose grid is like [1, 1, 1, 1], then the minimum sum to arrive at each point is simply an accumulation of previous points and the result is [1, 2, 3, 4].
 https://leetcode.com/problems/minimum-path-sum/discuss/23457/

 code:
 http://www.cnblogs.com/grandyang/p/4353255.html

 * Created by Helen on 1/7/2018.
 */
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null||grid[0].length==0||grid.length==0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m][n]; //size is m and n, not last index.
        sum[0][0] = grid[0][0]; // do not forget assign grid[0][0] to sum[0][0]
        for (int i = 1; i < m; i++) {
            sum[i][0] = sum[i-1][0] + grid[i][0];
        }
        for (int j = 1; j <n ; j++) {
            sum[0][j] = sum[0][j-1]+grid[0][j];
        }
        for (int i = 1; i < m; i++) {
            for(int j=1;j<n;j++){
                sum[i][j] = Math.min(sum[i-1][j],sum[i][j-1]) + grid[i][j];
            }
        }
        return sum[m-1][n-1];
    }
}
