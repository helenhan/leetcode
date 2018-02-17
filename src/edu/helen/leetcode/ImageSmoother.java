package edu.helen.leetcode;

/**
 * Created by Helen on 11/23/2017.
 */
public class ImageSmoother {
    public int[][] imageSmoother(int[][] M) {
        if (M == null || M.length == 0) return new int[0][0];
        int m = M.length, n = M[0].length;
        int[][] res = new int[m][n];
        int[][] moves = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {1, 1}, {1, -1}, {-1, 1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int sum = M[i][j];
                int count = 1;
                for (int[] move : moves) {
                    int x = i + move[0];
                    int y = j + move[1];
                    if (x >= 0 && x < m && y >= 0 && y < n) {
                        sum += M[x][y];
                        count++;
                    }

                }
                res[i][j] = sum / count;
            }
        }
        return res;
    }
}
