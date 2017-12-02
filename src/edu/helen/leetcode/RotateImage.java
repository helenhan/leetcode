package edu.helen.leetcode;

/**
 * Created by Helen on 9/21/2017.
 */
public class RotateImage {
    public void rotate(int[][] matrix) {
        if(matrix==null||matrix.length==0){
            return;
        }
        int n = matrix[0].length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int tmp = matrix[i][j];
                matrix[i][j]= matrix[i][n-1-j];
                matrix[i][n-1-j] = tmp;
            }
        }
    }
}
