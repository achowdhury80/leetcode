package comp.prep2019.less1000;

import java.util.TreeSet;

public class Prob363 {
	public int maxSumSubmatrix(int[][] matrix, int k) {
        int m, n;
        if ((m = matrix.length) == 0 || (n = matrix[0].length) == 0) return 0;
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
        	int[] arr = new int[n];
        	for (int j = i; j > -1; j--) {
        		TreeSet<Integer> treeSet = new TreeSet<>();
            	treeSet.add(0);
            	int val = 0;
        		for (int x = 0; x < n; x++) {
        			arr[x] += matrix[j][x];
        			val += arr[x];
        			Integer subRes = treeSet.ceiling(val - k);
        			if (subRes != null) result = Math.max(result, val - subRes);
        			treeSet.add(val);
        		}
        	}
        }
        return result;
    }
}
