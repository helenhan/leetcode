package com.helen.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
 * Created by Helen on 2/19/2018.
 */
public class WordSearchII {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        if(board==null||board.length==0||words==null||words.length==0){
            return res;
        }
        TrieNode root = buildTrie(words);
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                dfs(board,i,j,root,res);
            }
        }
        return res;
    }

    private void dfs(char[][] board,int i,int j, TrieNode p,List<String> res){
        char c = board[i][j];
        if(c=='#'||p.next[c-'a']==null) return;
        p = p.next[c-'a'];
        if(p.word!=null){
            res.add(p.word);
            p.word = null;
        }
        board[i][j]='#';
        if(i>0) dfs(board,i-1,j,p,res);
        if(i<board.length-1) dfs(board,i+1,j,p,res);
        if(j>0) dfs(board,i,j-1,p,res);
        if(j<board[0].length-1) dfs(board,i,j+1,p,res);
        board[i][j] = c;
    }

    private TrieNode buildTrie(String[] words){
        TrieNode root = new TrieNode();
        for(String w:words){
            TrieNode p = root;
            for(char c:w.toCharArray()){
                int idx = c-'a';
                if(p.next[idx]==null){
                    p.next[idx] = new TrieNode();
                }
                p = p.next[idx];
            }
            p.word = w;
        }
        return root;
    }

    class TrieNode{
        String word;
        TrieNode[] next = new TrieNode[26];
    }
}
