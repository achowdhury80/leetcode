package com.prep2020.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Problem499 {
	public String findShortestWay(int[][] maze, int[] ball, int[] hole) {
		int m = maze.length, n = maze[0].length;
		Queue<PositionInstruction> q = new PriorityQueue<>((x, y) -> x.pos[2] - y.pos[2]);
		int[][] distance = new int[m][n];
		String[][] instuctions = new String[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				distance[i][j] = Integer.MAX_VALUE;
				instuctions[i][j] = "impossible";
			}
		}
		q.offer(new PositionInstruction(new int[] {ball[0], ball[1], 0}, ""));
		distance[ball[0]][ball[1]] = 0;
		instuctions[ball[0]][ball[1]] = "";
		
		while(!q.isEmpty()) {
			PositionInstruction cur = q.poll();
			List<PositionInstruction> nexts = findNexts(maze, cur, hole);
			for (PositionInstruction next : nexts) {
				if (maze[next.pos[0]][next.pos[1]] == 1 
						|| distance[next.pos[0]][next.pos[1]] <= next.pos[2]) 
					continue;
				distance[next.pos[0]][next.pos[1]] = next.pos[2];
				instuctions[next.pos[0]][next.pos[1]] = next.instruction;
				q.offer(next);
			}
		}
		return instuctions[hole[0]][hole[1]];
    }
	
	private List<PositionInstruction> findNexts(int[][] maze, PositionInstruction start, int[] hole) {
		int m = maze.length, n = maze[0].length;
		List<PositionInstruction> result = new ArrayList<>();
		int[][] dirs = new int[][] {{1, 0}, {0, -1}, {0, 1},  {-1, 0}};
		String directions = "dlru";
		for (int i = 0; i < 4; i++) {
			PositionInstruction cur = new PositionInstruction(
					new int[] {start.pos[0], start.pos[1], start.pos[2]}, 
					start.instruction);
			while(true) {
				PositionInstruction next = new PositionInstruction(
						new int[] {cur.pos[0] + dirs[i][0], cur.pos[1] 
								+ dirs[i][1], cur.pos[2] + 1}, cur.instruction);
				if (next.pos[0] < 0 || next.pos[0] == m || next.pos[1] < 0 
						|| next.pos[1] == n 
						|| maze[next.pos[0]][next.pos[1]] == 1) break;
				cur = next;
				if (cur.pos[0] == hole[0] && cur.pos[1] == hole[1]) break;
			}
			if (cur.pos[0] != start.pos[0] || cur.pos[1] != start.pos[1]) {
				cur.instruction += directions.charAt(i);
				result.add(cur);
			}
		}
		return result;
	}
	
	class PositionInstruction {
		int[] pos;
		String instruction;
		PositionInstruction(int[] pos, String instruction) {
			this.pos = pos;
			this.instruction = instruction;
		}
	}
}
