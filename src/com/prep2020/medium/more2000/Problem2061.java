package com.prep2020.medium.more2000;

public class Problem2061 {
	public int numberOfCleanRooms(int[][] room) {
		int m = room.length, n = room[0].length;
		boolean[][][] visited = new boolean[m][n][4];
		boolean[][] cleaned = new boolean[m][n];
        int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
        int result = 0;
        int[] cur = new int[] {0, 0, 0};
        while(!visited[cur[0]][cur[1]][cur[2]]) {
        	visited[cur[0]][cur[1]][cur[2]] = true;
        	if (!cleaned[cur[0]][cur[1]]) {
        		cleaned[cur[0]][cur[1]] = true;
        		result++;
        	}
        	for (int i = 0; i < 4; i++) {
        		int dirIndex = (cur[2] + i) % 4;
        		int [] next = new int[] {cur[0] + dirs[dirIndex][0], 
        				cur[1] + dirs[dirIndex][1], dirIndex};
        		if (next[0] < 0 || next[0] == m || next[1] < 0 
        				|| next[1] == n || room[next[0]][next[1]] == 1) {
        			 continue;
        		}
        		cur = next;
        		break;
        	}
        }
        return result;
    }
}
