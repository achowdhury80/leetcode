package comp.prep2019.less2000;

public class Prob1139 {
	/**
	 * https://leetcode.com/problems/largest-1-bordered-square/discuss/345265/c%2B%2B-beats-100-(both-time-and-memory)-concise-with-algorithm-and-image
	 * @param grid
	 * @return
	 */
	public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] hor = new int[m][n], ver = new int[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (grid[i][j] == 1) {
	        		hor[i][j] = (j > 0 ? hor[i][j - 1] : 0) + grid[i][j];
	        		ver[i][j] = (i > 0 ? ver[i - 1][j] : 0) + grid[i][j];
        		}
        	}
        }
        int result = 0;
        for (int i = m - 1; i > -1; i--) {
        	for (int j = n - 1; j > -1; j--) {
        		if (grid[i][j] == 1) {
        			int small = Math.min(hor[i][j], ver[i][j]);
        			while(small > result) {
        				if (ver[i][j - small + 1] >= small && hor[i - small + 1][j] >= small) {
        					result = small;
        					break;
        				}
        				small--;
        			}
        			
        		}
        	}
        }
        return result * result;
    }
	
	public static void main(String[] args) {
		Prob1139 prob = new Prob1139();
		int[][] grid = new int[][] {{1,1,1}, {1, 0, 1}, {1, 1, 1}};
		System.out.println(prob.largest1BorderedSquare(grid));
	}
}
