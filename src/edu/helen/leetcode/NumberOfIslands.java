package edu.helen.leetcode;

/**
 * Created by Helen on 10/11/2017.
 */
public class NumberOfIslands {
    private int row;
    private int column;
    public int numIslands(char[][] grid) {
         row = grid.length;
        if(row==0) return 0;
         column = grid[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]=='0') continue;
                DFSMarking(grid,i,j);
                ++count;
            }
        }
        return count;
    }

    private void DFSMarking(char[][] grid, int x,int y){
        if(x<0||y<0||x>=row||y>=column||grid[x][y]!='1') return;
        grid[x][y]='0';
        DFSMarking(grid,x,y+1);
        DFSMarking(grid,x,y-1);
        DFSMarking(grid,x+1,y);
        DFSMarking(grid,x-1,y);

    }
}
