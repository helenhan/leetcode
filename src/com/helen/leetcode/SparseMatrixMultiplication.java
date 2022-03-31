package com.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/sparse-matrix-multiplication/discuss/76154/Easiest-JAVA-solution
 * A sparse matrix can be represented as a sequence of rows, each of which is a sequence of (column-number, value) pairs of the nonzero values in the row.
 * Created by Helen on 3/4/2018.
 */
public class SparseMatrixMultiplication {

    public int[][] multiply(int[][] A, int[][] B) {
        int m = A.length;
        int n = A[0].length;
        int nB = B[0].length;
        List[] lists = new List[m];
        int[][] res = new int[m][nB];
        for (int i = 0; i < m; i++) {
            List<Integer> tmp = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (A[i][j] != 0) {
                    tmp.add(j);
                    tmp.add(A[i][j]);
                }
            }
            lists[i] = tmp;
        }

        for (int i = 0; i < m; i++) {
            List<Integer> list = lists[i];
            for (int p = 0; p < list.size() - 1; p += 2) {
                int colA = list.get(p);
                int valA = list.get(p + 1);
                for (int j = 0; j < nB; j++) {
                    res[i][j] += valA * B[colA][j];
                }
            }
        }
        return res;

    }
}
