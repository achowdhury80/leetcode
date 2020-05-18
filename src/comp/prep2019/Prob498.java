package comp.prep2019;

public class Prob498 {
	public int[] findDiagonalOrder(int[][] matrix) {
		if (matrix.length == 0) return new int[0];
		int m = matrix.length, n = matrix[0].length;
        int[][] dirs = new int[][] {{-1, 1}, {1, -1}};
        int curDir = 0;
        int[] result = new int[m * n];
        int[] cur = new int[] {0, 0};
        for (int i = 0; i < m * n; i++) {
        	result[i] = matrix[cur[0]][cur[1]];
        	int[] next = new int[] {cur[0] + dirs[curDir][0], cur[1] + dirs[curDir][1]};
        	if (next[0] < 0 && next[1] == n) {
        		next = new int[] {cur[0] + 1, cur[1]};
        		curDir = (curDir + 1) % 2;
        	} else if (next[0] < 0) {
        		next = new int[] {cur[0], cur[1] + 1};
        		curDir = (curDir + 1) % 2;
        	} else if (next[1] == n) {
        		next = new int[] {cur[0] + 1, cur[1]};
        		curDir = (curDir + 1) % 2;
        	} else if (next[0] == m && next[1] < 0) {
        		next = new int[] {cur[0], cur[1] + 1};
        		curDir = (curDir + 1) % 2;
        	} else if (next[0] == m) {
        		next = new int[] {cur[0], cur[1] + 1};
        		curDir = (curDir + 1) % 2;
        	} else if (next[1] < 0) {
        		next = new int[] {cur[0] + 1, cur[1]};
        		curDir = (curDir + 1) % 2;
        	}
        	cur = next;
        }
        return result;
    }
}
