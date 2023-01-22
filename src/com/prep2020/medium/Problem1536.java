package com.prep2020.medium;
import java.util.*;
public class Problem1536 {
	 public int minSwaps(int[][] grid) {
	        int n = grid.length;
	        int []arr = new int[n];
	        for (int i = 0; i < n; i++) {
	            for (int j = n - 1; j >= 0; j--) {
	                if (grid[i][j] == 1) {
	                    break;
	                }
	                arr[i]++;
	            }
	        }

	        int sum = 0;
	        HashSet<Integer> set = new HashSet<>();
	        for (int i = n - 1; i >= 0; i--) {
	            boolean notfound = true;
	            for (int j = 0; j < n; j++) {
	                if (set.contains(j)) {
	                    continue;
	                }
	                if (arr[j] >= i) {
	                    set.add(j);
	                    notfound = false;
	                    break;
	                } else {
	                    sum++;
	                }
	            }
	            if (notfound) {
	                return -1;
	            }
	        }
	        return sum;
	    }
}
