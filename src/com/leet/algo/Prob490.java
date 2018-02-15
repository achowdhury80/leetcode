package com.leet.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayanc on 2/14/18.
 */
public class Prob490 {
  public boolean hasPath(int[][] maze, int[] start, int[] destination) {
    int m, n;
    if (maze == null || (m = maze.length) < 1 || (n = maze[0].length) < 1) return false;
    if (maze[start[0]][start[1]] == 1 || maze[destination[0]][destination[1]] == 1) return false;
    if (start[0] == destination[0] && start[1] == destination[1]) return true;
    boolean[][] visited = new boolean[m][n];
    int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    Queue<int[]> q = new LinkedList<>();
    visited[start[0]][start[1]] = true;
    q.offer(start);
    while (!q.isEmpty()) {
      int[] pos = q.poll();
      for (int[] move : direction) {
        int[] nextPos = findNextPosition(pos, move, m, n, maze);
        if (nextPos[0] < m && nextPos[0] > -1 && nextPos[1] < n && nextPos[1] > -1 && maze[nextPos[0]][nextPos[1]] != 1 && !visited[nextPos[0]][nextPos[1]]) {
          visited[nextPos[0]][nextPos[1]] = true;
          if (destination[0] == nextPos[0] && destination[1] == nextPos[1]) return true;
          q.offer(nextPos);
        }
      }
    }
    return false;
  }

  private int[] findNextPosition(int[] pos, int[] move, int m, int n, int[][] maze) {
    int[] currentPos = pos;
    int[] nextPos = new int[]{pos[0] + move[0], pos[1] + move[1]};
    while (nextPos[0] < m && nextPos[0] > -1 && nextPos[1] < n && nextPos[1] > -1 && maze[nextPos[0]][nextPos[1]] != 1) {
      currentPos = nextPos;
      nextPos = new int[]{currentPos[0] + move[0], currentPos[1] + move[1]};
    }
    return currentPos;
  }



  public static void main(String[] args) {
    Prob490 prob490 = new Prob490();
    System.out.println(prob490.hasPath(new int[][]{{0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 0, 1, 1},
        {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{4,4}));

    System.out.println(prob490.hasPath(new int[][]{
        {0, 0, 1, 0, 0},
        {0, 0, 0, 0, 0},
        {0, 0, 0, 1, 0},
        {1, 1, 0, 1, 1},
        {0, 0, 0, 0, 0}}, new int[]{0, 4}, new int[]{3, 2}));

  }


}
