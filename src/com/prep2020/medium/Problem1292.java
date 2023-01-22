package com.prep2020.medium;

public class Problem1292 {
	public int maxSideLength(int[][] mat, int threshold) {
        int n = mat.length, m = mat[0].length;
        
        int[][] sum  = new int[n + 1][m + 1];
        int max = 0;
        
        // sum[i][j]: area from top-left corner [0, 0] to bottom-right corner [i, j]
        for(int i  = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                sum[i][j] = sum[i][j -1] + sum[i-1][j] + mat[i - 1][j - 1] - sum[i - 1][j - 1];  
                
            }
        }
        
        for(int i  = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if (i - max > 0 && j - max > 0) {
                    int area = sum[i][j] - sum[i][j - max - 1] - sum[i - max - 1][j] + sum[i - max - 1][j - max - 1];
					// once found the current max, check other possible grids, no need to do while loop here
                    if (area <= threshold) {
                        max += 1;
                    }
                }
            }
        }
        return max;
    }
}
