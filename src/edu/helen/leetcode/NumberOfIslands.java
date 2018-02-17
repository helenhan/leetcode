package edu.helen.leetcode;

/**
 * 0代表海，1代表岛，如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * Linear scan the 2d grid map, if a node contains a '1', then it is a root node that triggers a Depth First Search. During DFS,
 * every visited node should be set as '0' to mark as visited node. Count the number of root nodes that trigger DFS,
 * this number would be the number of islands since each DFS starting at some root identifies an island.
 * <p>
 * Time complexity : OO(M×N) where M is the number of rows and N is the number of columns.
 * Space complexity : worst case O(M×N) in case that the grid map is filled with lands where DFS goes by M×N deep.
 * <p>
 * https://leetcode.com/problems/number-of-islands/solution/
 * Created by Helen on 10/11/2017.
 */
public class NumberOfIslands {
    private int row;
    private int column;

    public int numIslands(char[][] grid) {
        row = grid.length;
        if (row == 0) return 0;
        column = grid[0].length;
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (grid[i][j] == '0') continue;
                DFSMarking(grid, i, j);
                ++count; // after DFS, the nodes in the same island are all marked as visited "0", next node that trigger another DFS would be another island.
            }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= row || y >= column || grid[x][y] != '1') return;
        grid[x][y] = '0'; // mark this node as visited node
        DFSMarking(grid, x, y + 1);
        DFSMarking(grid, x, y - 1);
        DFSMarking(grid, x + 1, y);
        DFSMarking(grid, x - 1, y);

    }
}
