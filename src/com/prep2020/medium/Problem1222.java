package com.prep2020.medium;
import java.util.*;
public class Problem1222 {
	public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[][] blocked = new boolean[8][8];
		for (int[] queen : queens) blocked[queen[0]][queen[1]] = true;
		for (int[] queen : queens) {
			boolean flag = false;
			if (king[0] == queen[0]) {
				int start = Math.min(king[1], queen[1]), end = Math.max(king[1], queen[1]);
				for (int i = start + 1; i < end; i++) {
					if (blocked[queen[0]][i]) {
						flag = true;
						break;
					}
				}
				if (flag) continue;
				result.add(Arrays.asList(queen[0], queen[1]));
				continue;
			} else if (king[1] == queen[1]) {
				int start = Math.min(king[0], queen[0]), end = Math.max(king[0], queen[0]);
				for (int i = start + 1; i < end; i++) {
					if (blocked[i][queen[1]]) {
						flag = true;
						break;
					}
				}
				if (flag) continue;
				result.add(Arrays.asList(queen[0], queen[1]));
				continue;
			} else if (Math.abs(king[0] - queen[0]) == Math.abs(king[1] - queen[1])) {
				int rowDir = king[0] - queen[0] > 0 ? 1 : -1;
				int colDir = king[1] - queen[1] > 0 ? 1 : - 1;
				int[] cur = new int[] {queen[0] + rowDir, queen[1] + colDir};
				while(cur[0] != king[0] && cur[1] != king[1]) {
					if (blocked[cur[0]][cur[1]]) {
						flag = true;
						break;
					}
					cur[0] += rowDir;
					cur[1] += colDir;
				}
				if (flag) continue;
				result.add(Arrays.asList(queen[0], queen[1]));
				continue;
			}
		}
		return result;
    }
}
