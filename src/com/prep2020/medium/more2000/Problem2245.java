package com.prep2020.medium.more2000;
public class Problem2245 {
	public int maxTrailingZeros(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][][] down = new int[m][n][2];
        int[][][] up = new int[m][n][2];
        int[][][] left = new int[m][n][2];
        int[][][] right = new int[m][n][2];
        
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                int two = divide(grid[i][j], 2);
                int five =  divide(grid[i][j], 5);
                
                up[i][j][0] = (i == 0)? two : two + up[i - 1][j][0];
                left[i][j][0] = (j == 0)? two : two + left[i][j - 1][0];
                up[i][j][1] = (i == 0)? five : five + up[i - 1][j][1];
                left[i][j][1] = (j == 0)? five : five + left[i][j - 1][1];
            }
        }
        
        for(int i = m - 1; i >= 0; --i) {
            for(int j = n - 1; j >= 0; --j) {
                int two = divide(grid[i][j], 2);
                int five =  divide(grid[i][j], 5);
                
                down[i][j][0] = (i == m - 1)? two : two + down[i + 1][j][0];
                right[i][j][0] = (j == n - 1)? two : two + right[i][j + 1][0];
                down[i][j][1] = (i == m - 1)? five : five + down[i + 1][j][1];
                right[i][j][1] = (j == n - 1)? five : five + right[i][j + 1][1];
            }
        }
        
        int res = 0;
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                int two = divide(grid[i][j], 2);
                int five = divide(grid[i][j], 5);
                
                int sol1 = Math.min(up[i][j][0] + right[i][j][0] - two, up[i][j][1] + right[i][j][1] - five);
                int sol2 = Math.min(right[i][j][0] + down[i][j][0] - two, right[i][j][1] + down[i][j][1] - five);
                int sol3 = Math.min(down[i][j][0] + left[i][j][0] - two, down[i][j][1] + left[i][j][1] - five);
                int sol4 = Math.min(left[i][j][0] + up[i][j][0] - two, left[i][j][1] + up[i][j][1] - five);

                res = Math.max(res, Math.max(Math.max(sol1, sol2), Math.max(sol3, sol4)));
                
            }
        }
        return res;
    }
    
    public int divide(int val, int d) {
        //System.out.println(val);
        int res = 0;
        while(val > 0 && val % d == 0) {
            ++res;
            val /= d;
        }
        return res;
    }
	
	public static void main(String[] args) {
		Problem2245 problem = new Problem2245();
		//System.out.println(problem.maxTrailingZeros(new int[][]{{23,17,15,3,20},{8,1,20,27,11},{9,4,6,2,21},{40,9,1,10,6},{22,7,4,5,3}}));
		System.out.println(problem.maxTrailingZeros(new int[][]{{10},{16},{15}}));
	}
}
