package comp.prep2019;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Prob505 {
	public int shortestDistance(int[][] maze, int[] start, int[] destination) {
	    int m, n;
	    if (maze == null || (m = maze.length) < 1 || (n = maze[0].length) < 1) return -1;
	    if (maze[start[0]][start[1]] == 1 || maze[destination[0]][destination[1]] == 1) return -1;
	    if (start[0] == destination[0] && start[1] == destination[1]) return 0;
	    boolean[][] visited = new boolean[m][n];
	    int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	    Queue<int[]> q = new PriorityQueue<>((x, y) -> x[2] - y[2]);
	    q.offer(new int[]{start[0], start[1], 0});
	    while (!q.isEmpty()) {
	      int[] pos = q.poll();
	      if (visited[pos[0]][pos[1]]) continue;
	      visited[pos[0]][pos[1]] = true;
	      if (pos[0] == destination[0] && pos[1] == destination[1]) return pos[2];
	      for (int[] move : direction) {
	        int[] nextPos = findNextPosition(pos, move, m, n, maze);
	        if (nextPos[0] == pos[0] && nextPos[1] == pos[1]) continue;
	        if (visited[nextPos[0]][nextPos[1]]) continue;
	        q.offer(nextPos);
	      }
	    }
	    return -1;
	  }
	public int shortestDistance1(int[][] maze, int[] start, int[] destination) {
	    int m, n;
	    if (maze == null || (m = maze.length) < 1 || (n = maze[0].length) < 1) return -1;
	    if (maze[start[0]][start[1]] == 1 || maze[destination[0]][destination[1]] == 1) return -1;
	    if (start[0] == destination[0] && start[1] == destination[1]) return 0;
	    int[][] visited = new int[m][n];
	    for (int i = 0; i < m ; i++) {
	      for (int j = 0; j < n; j++){
	        visited[i][j] = Integer.MAX_VALUE;
	      }
	    }
	    int[][] direction = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
	    Queue<int[]> q = new LinkedList<>();
	    visited[start[0]][start[1]] = 0;
	    q.offer(new int[]{start[0], start[1], 0});
	    while (!q.isEmpty()) {
	      int[] pos = q.poll();
	      for (int[] move : direction) {
	        int[] nextPos = findNextPosition(pos, move, m, n, maze);
	        if (nextPos[0] == pos[0] && nextPos[1] == pos[1]) continue;
	        if (nextPos[2] < visited[nextPos[0]][nextPos[1]]) {
	          visited[nextPos[0]][nextPos[1]] = nextPos[2];
	          q.offer(nextPos);
	        }
	      }
	    }
	    return visited[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : visited[destination[0]][destination[1]];
	  }

	  private int[] findNextPosition(int[] pos, int[] move, int m, int n, int[][] maze) {
	    int[] currentPos = pos;
	    int[] nextPos = new int[]{pos[0] + move[0], pos[1] + move[1], currentPos[2] + 1};
	    while (nextPos[0] < m && nextPos[0] > -1 && nextPos[1] < n && nextPos[1] > -1 && maze[nextPos[0]][nextPos[1]] != 1) {
	      currentPos = nextPos;
	      nextPos = new int[]{currentPos[0] + move[0], currentPos[1] + move[1], currentPos[2] + 1};
	    }
	    return currentPos;
	  }
}
