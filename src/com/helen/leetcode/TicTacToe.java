package com.helen.leetcode;

/**
 * https://leetcode.com/problems/design-tic-tac-toe/discuss/81898/Java-O(1)-solution-easy-to-understand
 * Initially, I had not read the Hint in the question and came up with an O(n) solution. After reading the extremely helpful hint;
 * a much easier approach became apparent. The key observation is that in order to win Tic-Tac-Toe you must have the entire row or column.
 * Thus, we don’t need to keep track of an entire n^2 board. We only need to keep a count for each row and column.
 * If at any time a row or column matches the size of the board then that player has won.

 To keep track of which player, I add one for Player1 and -1 for Player2. There are two additional variables to
 keep track of the count of the diagonals. Each time a player places a piece we just need to check the count of that row, column, diagonal and anti-diagonal.
 * Created by Helen on 3/3/2018.
 */
public class TicTacToe {
    private int[] rows;
    private int[] cols;
    private int diagonal;
    private int antiDiagonal;

    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        antiDiagonal = 0;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        int toAdd = player==1?1:-1;
        rows[row] += toAdd;
        cols[col] += toAdd;
        if(row==col){
            diagonal += toAdd;
        }
        if(row+col == rows.length-1){
            antiDiagonal += toAdd;
        }
        int size = rows.length;
        if(Math.abs(rows[row])==size||Math.abs(cols[col])==size||Math.abs(diagonal)==size||Math.abs(antiDiagonal)==size){
            return player;
        }
        return 0;
    }
}
