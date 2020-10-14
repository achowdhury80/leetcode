package comp.prep2019.less1000;

public class Prob566 {
	public int[][] matrixReshape(int[][] nums, int r, int c) {
        int m = nums.length, n = nums[0].length;
        if (r * c != m * n) return nums;
        int[][] result = new int[r][c];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		int count = i * n + j;
        		int[] loc = new int[] {count / c, count % c};
        		result[loc[0]][loc[1]] = nums[i][j];
        	}
        }
        return result;
    }
}
