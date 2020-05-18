package comp.prep2019;

import java.util.*;

public class Prob835 {
	/*
	 * O(m^2)
	 * Basic brute-force approach - calculate "overlap" at by aligning B over A at every co-ordinate of A.
But we can save time in counting only co-ordinate with 1 in every aligning situation.
To differntiate one aligning situation from the other, we can look at offset which is constant for one aligning situation (say (0,0) from A aligned with (1,3) from B).
In other words, difference between corresponding co-ordinates is same in one aligning situtation.
	 */
	public int largestOverlap(int[][] A, int[][] B) {
        List<int[]> aList = new ArrayList<>();
        List<int[]> bList = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < A[0].length; j++) {
        		if (A[i][j] == 1) aList.add(new int[] {i, j});
        		if (B[i][j] == 1) bList.add(new int[] {i, j});
        	}
        }
        int result = 0;
        Map<String, Integer> overlaps = new HashMap<>();
        for (int[] a : aList) {
        	for (int[] b : bList) {
        		String offset = (a[0] - b[0]) + "," + (a[1] - b[1]);
        		overlaps.put(offset, overlaps.getOrDefault(offset, 0) + 1);
        		result = Math.max(result, overlaps.get(offset));
        	}
        }
        return result;
    }
}
