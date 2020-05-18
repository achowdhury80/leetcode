package comp.prep2019;
import java.util.*;
public class Prob1380 {
	public List<Integer> luckyNumbers (int[][] matrix) {
		int m = matrix.length, n = matrix[0].length;
        int[] mins = new int[m], maxs = new int[n];
        Arrays.fill(mins, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		mins[i] = Math.min(mins[i], matrix[i][j]);
        		maxs[j] = Math.max(maxs[j], matrix[i][j]);
        	}
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		if (matrix[i][j] == mins[i] && matrix[i][j] == maxs[j]) 
        			result.add(matrix[i][j]);
        	}
        }
        return result;
    }
}
