package com.prep2020.medium;

import java.util.*;

public class Problem1820_old {
	private static final int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };
	private static final char[] FORWARD_DIRECTION = { 'U', 'D', 'L', 'R' };
	private static final char[] BACKWARD_DIRECTION = { 'D', 'U', 'R', 'L' };

	private int[] target;
	private Map<Integer, Map<Integer, Integer>> board = new HashMap<>();

	public int findShortestPath(GridMaster master) {
		dfs(master, 0, 0);
		return (target == null ? -1 : bfs(master));
	}

	private int bfs(GridMaster master) {

		PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]); // storing {row, col, cost}
		heap.offer(new int[] { 0, 0, 0 });
		while (!heap.isEmpty()) {
			int[] curr = heap.poll();
			int currRow = curr[0];
			int currCol = curr[1];
			int costSoFor = curr[2];

			if (currRow == target[0] && currCol == target[1])
				return costSoFor;

			for (int d = 0; d < 4; d++) {
				int nextRow = currRow + DIRECTIONS[d][0];
				int nextCol = currCol + DIRECTIONS[d][1];
				if (!board.containsKey(nextRow) || !board.get(nextRow).containsKey(nextCol))
					continue; // nextRow or nextCol not present

				int nextPathCost = board.get(nextRow).get(nextCol);
				board.get(nextRow).remove(nextCol); // remove the path. So that alternate route cannot use the same path
													// again.

				int newCost = costSoFor + nextPathCost;
				heap.offer(new int[] { nextRow, nextCol, newCost }); // add to queue
			}
		}

		return -1;
	}

	private void dfs(GridMaster master, int currRow, int currCol) {
	    if (master.isTarget()) target = new int[] {currRow, currCol};

	    for (int d = 0; d < 4; d++) {
	      int nextRow = currRow + DIRECTIONS[d][0];
	      int nextCol = currCol + DIRECTIONS[d][1];

	      char front = FORWARD_DIRECTION[d]; // direction of moving 
	      char back = BACKWARD_DIRECTION[d]; // direction of backtracking

	      if (board.containsKey(nextRow) && board.get(nextRow).containsKey(nextCol)) continue;

	      if (!master.canMove(front)) continue;

	      int cost = master.move(front);
	      board.computeIfAbsent(nextRow, v -> new HashMap<>()).put(nextCol, cost);
	      dfs(master, nextRow, nextCol);
	      master.move(back);
	      // backTrack the move.

	    }
	}

	interface GridMaster {
		boolean canMove(char direction);

		int move(char direction);

		boolean isTarget();
	}
}
