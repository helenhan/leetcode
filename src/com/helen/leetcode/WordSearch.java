package com.helen.leetcode;

/**
 * https://leetcode.com/problems/word-search/discuss/27658/Accepted-very-short-Java-solution.-No-additional-space.
 * Created by Helen on 2/19/2018.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if(board==null||board.length==0||word==null||word.length()==0){
            return false;
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(helper(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false ;
    }
    private boolean helper(char[][] board, int i,int j, String word,int idx){
        if(idx == word.length()) return true;
        if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]!=word.charAt(idx)){
            return false;
        }
        board[i][j] = '*';
        boolean res = helper(board,i+1,j,word,idx+1) ||
                helper(board,i-1,j,word,idx+1) ||
                helper(board,i,j+1,word,idx+1) ||
                helper(board,i,j-1,word,idx+1) ;
        board[i][j] = word.charAt(idx);
        return res;
    }
}
