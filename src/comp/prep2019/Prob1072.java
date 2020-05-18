package comp.prep2019;

import java.util.Arrays;

public class Prob1072 {
	public int maxEqualRowsAfterFlips(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 1;
        for (int i = 0; i < m; i++) {
        	int cnt = 0;
        	for (int j = 0; j < m; j++) {
        		int[] flip = new int[n];
        		for (int k = 0; k < n; k++) flip[k] = 1 - matrix[j][k];
        		if (Arrays.equals(matrix[i], matrix[j]) || Arrays.equals(matrix[i], flip)) cnt++;
        	}
        	ans = Math.max(ans, cnt);
        }
        return ans;
    }
}
