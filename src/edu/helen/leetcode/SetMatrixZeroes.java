package edu.helen.leetcode;

/**
 * https://discuss.leetcode.com/topic/5056/any-shorter-o-1-space-solution?page=1
 * store states of each row in the first of that row, and store states of each column in the first of that column.
 * Because the state of row0 and the state of column0 would occupy the same cell, I let it be the state of row0,
 * and use another variable "col0" for column0. In the first phase, use matrix elements to set states in a top-down way.
 * In the second phase, use states to set matrix elements in a bottom-up way.
 *
 *http://bangbingsyb.blogspot.ca/2014/11/leetcode-set-matrix-zeroes.html
 * 这题题意不是很清楚。很容易让人觉得置0是“连锁反应”，造成最后每个元素都为0。而实际题目的意思是，
 * 只有在原始矩阵中为0的数字才能将相应行列置0。而原本非0的数字，即使由于同行或同列的0元素而被置0了，也不能将它相关的行列置0。即这种置0的操作没有传递性，

 1. O(mn)解法：克隆原来的matrix，然后扫描原来的matrix，遇到0，则在克隆版本中将对应的行列置0。
 2. O(m+n)解法：用两个bool数组O(n)和O(m)，分别记录每行和每列的是否需要被置0。最后根据这两个数组来置0整个矩阵。
 3. O(1)解法：用第0行和第0列来记录第1 ~ m-1行和第1 ~ n-1列是否需要置0。而用两个变量记录第0行和第0列是否需要置0。 这个解法跟下面的解法有些许不同。

 * Created by Helen on 12/2/2017.
 */
public class SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        if(matrix==null||matrix.length==0) return;
        int col0=1;
        int row=matrix.length,column=matrix[0].length;
        for(int i=0;i<row;i++){
            if(matrix[i][0]==0) col0=0;
            for(int j=1;j<column;j++){
                if(matrix[i][j]==0){
                    matrix[i][0] =0;
                    matrix[0][j] =0;
                }
            }
        }
        for(int i=row-1;i>=0;i--){
            for(int j=column-1;j>=1;j--){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
            if(col0==0){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String[] args) {
        SetMatrixZeroes s = new SetMatrixZeroes();
        s.setZeroes(new int[][]{{1,1,1},{0,1,2}});
    }
}
