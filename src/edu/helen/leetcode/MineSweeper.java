package edu.helen.leetcode;

/**
 * https://discuss.leetcode.com/topic/80802/java-solution-dfs-bfs
 * Created by Helen on 11/21/2017.
 */
public class MineSweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int n = board.length, m = board[0].length, row = click[0], col = click[1];
        if (board[row][col] == 'M') {
            board[row][col] = 'X';
        } else {
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    int x = row + i, y = col + j;
                    if (x < 0 || x >= n || y < 0 || y >= m) continue;
                    if (board[x][y] == 'M') count++;
                }
            }
            if (count > 0) {
                board[row][col] = (char) (count + '0');
            } else {
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int x = row + i, y = col + j;
                        if (x < 0 || x >= n || y < 0 || y >= m) continue;
                        if (board[x][y] == 'E'){
                            updateBoard(board,new int[]{x,y});
                        }
                    }
                }
            }
        }
        return board;
    }
}
