package edu.helen.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Since we have to cut trees in order of their height, we first put trees (int[] {row, col, height}) into a priority queue and sort by height.
 * Poll each tree from the queue and use BFS to find out steps needed.
 * The worst case time complexity could be O(m^2 * n^2) (m = number of rows, n = number of columns) since there are m * n trees and for each BFS worst case time complexity is O(m * n) too.
 * https://discuss.leetcode.com/topic/103052/java-solution-priorityqueue-bfs
 * Created by Helen on 11/25/2017.
 */
public class CutTreeOfGolfEvent {
    static int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int cutOffTree(List<List<Integer>> forest) {
        if (forest == null || forest.size() == 0) return 0;
        int m = forest.size(), n = forest.get(0).size();
        //sort trees by height and add all tree in a PriorityQueue.
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (forest.get(i).get(j) > 1) {
                    queue.add(new int[]{i, j, forest.get(i).get(j)});//i,j,height
                }
            }
        }
        int[] start = new int[2];
        int sum = 0;
        while (!queue.isEmpty()) {
            int[] tree = queue.poll();
            int step = getMinStep(forest, start, tree, m, n);//from start to tree
            if (step < 0) return -1;
            sum += step;
            start[0] = tree[0];
            start[1] = tree[1];
        }
        return sum;

    }

    private int getMinStep(List<List<Integer>> forest, int[] start, int[] tree, int m, int n) {
        int steps = 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        visited[start[0]][start[1]] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                if (curr[0] == tree[0] && curr[1] == tree[1]) return steps;
                for (int[] dir : dirs) {
                    int x = curr[0] + dir[0];
                    int y = curr[1] + dir[1];
                    if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || forest.get(x).get(y) == 0) continue;
                    queue.add(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
            steps++; // notice that queue stores every possible step.
        }
        return -1;
    }


}
