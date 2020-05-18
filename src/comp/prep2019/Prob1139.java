package comp.prep2019;

public class Prob1139 {
	public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
        			int hCount = 1, vCount = 1;
        			if (j > 0) hCount += (grid[i][j - 1] >> 1) & ((1 << 7) - 1);
        			if (i > 0) vCount += (grid[i - 1][j] >> 8) & ((1 << 7) - 1);
        			grid[i][j] ^= (hCount << 1);
        			grid[i][j] ^= (vCount << 8);
        			int d = Math.min(hCount, vCount);
        			result = Math.max(result, 1);
        			for (int k = d; k > 1; k--) {
        				if (
        						((grid[i - k + 1][j] >> 1) & ((1 << 7) - 1)) >= k &&
        						((grid[i][j - k + 1] >> 8) & ((1 << 7) - 1)) >= k
        				) {
        					result = Math.max(result, k * k);
        					break;
        				}
        			}
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1139 prob = new Prob1139();
		int[][] grid = new int[][] {{1,1,1}, {1, 0, 1}, {1, 1, 1}};
		System.out.println(prob.largest1BorderedSquare(grid));
	}
}
