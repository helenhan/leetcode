package com.helen.leetcode;

/**
 * https://discuss.leetcode.com/topic/20064/my-concise-o-m-n-java-solution/2
 * We start search the matrix from top right corner, initialize the current position to top right corner,
 * if the target is greater than the value in current position,
 * then the target can not be in entire row of current position because the row is sorted,
 * if the target is less than the value in current position, then the target can not in the entire column because the column is sorted too.
 * We can rule out one row or one column each time, so the time complexity is O(m+n).
 * Created by Helen on 10/14/2017.
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return false;
        int n = matrix.length;
        int m = matrix[0].length;
        int col = m - 1;
        int row = 0;
        while (col >= 0 && row < n) {
            if (target < matrix[row][col]) {
                col--;
            } else if (target > matrix[row][col]) {
                row++;
            } else {
                return true;
            }
        }
        return false;
    }


    public boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int row = 0;
        int col = n - 1;
        while (row < m && col >= 0) {
            if(target>matrix[row][col]){
                row++;
            }else if(target<matrix[row][col]){
                col--;
            }else{
                return true;
            }
        }
        return false;
    }

}
