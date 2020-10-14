package comp.prep2019;

public class Prob59 {
	/**
	 * O(N)
	 * @param n
	 * @return
	 */
	public int[][] generateMatrix(int n) {
		if (n < 1) return new int[0][];
        int[][] result = new int[n][n];
        int[] start = new int[] {0, 0};
        int w = n, cur = 1;
        while(w > 0) {
        	if (w == 1) {
        		result[start[0]][start[1]] = cur;
        		cur++;
        	} else {
        		for (int i = 0; i < w - 1; i++) {
        			result[start[0]][start[1] + i] = cur;
        			cur++;
        		}
        		for (int i = 0; i < w - 1; i++) {
        			result[start[0] + i][start[1] + w - 1] = cur;
        			cur++;
        		}
        		for (int i = 0; i < w - 1; i++) {
        			result[start[0] + w - 1][start[1] + w - 1 - i] = cur;
        			cur++;
        		}
        		for (int i = 0; i < w - 1; i++) {
        			result[start[0] + w - 1 - i][start[1]] = cur;
        			cur++;
        		}
        	}
        	w -= 2;
        	start[0]++;
        	start[1]++;
        }
        return result;
    }
}
