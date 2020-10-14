package comp.prep2019.less1000;
import java.util.*;
public class Prob54 {
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if (m < 1) return result;
        int n = matrix[0].length;
        int[] start = new int[] {0, 0};
        while(m > 0 && n > 0) {
        	if (m == 1 || n == 1) {
        		if (m == 1) {
        			for (int i = 0; i < n; i++) {
        				result.add(matrix[start[0]][start[1] + i]);
        			}
        		} else {
        			for (int i = 0; i < m; i++) {
        				result.add(matrix[start[0] + i][start[1]]);
        			}
        		}
        	} else {
        		for (int i = 0; i < n - 1; i++) {
        			result.add(matrix[start[0]][start[1] + i]);
        		}
        		for (int i = 0; i < m - 1; i++) {
        			result.add(matrix[start[0] + i][start[1] + n - 1]);
        		}
        		for (int i = 0; i < n - 1; i++) {
        			result.add(matrix[start[0] + m - 1][start[1] + n - 1 - i]);
        		}
        		for (int i = 0; i < m - 1; i++) {
        			result.add(matrix[start[0] + m - 1 - i][start[1]]);
        		}
        	}
        	start[0]++;
        	start[1]++;
        	n -= 2;
        	m -= 2;
        }
        return result;
    }
}
