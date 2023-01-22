package comp.prep2019.less1000;

public class Prob59 {
	/**
	 * O(n*n)
	 * @param n
	 * @return
	 */
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int w = n, val = 1;
		int[] cur = new int[] {0, 0};
		int[][] dirs = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        while(w > 0) {
        	if (w == 1) {
        		result[cur[0]][cur[1]] = val;
        		break;
        	}
        	for (int[] dir : dirs) {
        		for (int i = 0; i < w - 1; i++) {
        			result[cur[0]][cur[1]] = val++;
        			cur[0] += dir[0];
        			cur[1] += dir[1];
        		}
        	}
        	cur[0]++;
        	cur[1]++;
        	w -= 2;
        }
        return result;
    }
}
