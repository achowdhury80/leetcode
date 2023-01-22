package com.prep2020.medium;

public class Problem845 {
	public int longestMountain(int[] arr) {
        int up = 1, down = 0;
        int result = 0;
        for (int i = 1; i < arr.length; i++) {
        	if (arr[i] >= arr[i - 1]) {
        		if (up > 1 && down > 1) result = Math.max(result, up + down - 1);
        		if (arr[i] == arr[i - 1]) up = 1;
        		else up = down > 0 ? 2 : up + 1;
        		down = 0;
        	} else {
        		if (up < 2) continue;
        		down = down == 0 ? 2 : down + 1;
        	}
        }
        if (up > 0 && down > 0) result = Math.max(result, up + down - 1);
        return result;
    }
	
	public static void main(String[] args) {
		Problem845 problem = new Problem845();
		System.out.println(problem.longestMountain(new int[] {2, 1, 4, 7, 3, 2, 5}));
	}
}
