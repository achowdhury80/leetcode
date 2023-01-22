package com.prep2020.easy;
public class Problem2078 {
	/**
	 * O(N) time and O(1) space
	 * @param colors
	 * @return
	 */
	public int maxDistance(int[] colors) {
		// take earliest two colors
        int[][] arr = new int[2][2];
        arr[0][0] = colors[0];
        arr[1][0] = -1;
        int result = 0;
        for (int i = 1; i < colors.length; i++) {
        	if (arr[0][0] == colors[i]) {
        		if (arr[1][0] != -1) {
        			result = Math.max(result, i - arr[1][1]);
        		}
        	} else {
        		result = Math.max(result, i - arr[0][1]);
        		if (arr[1][0] == -1) {
        			arr[1][0] = colors[i];
        			arr[1][1] = i;
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2078 problem = new Problem2078();
		System.out.println(problem.maxDistance(new int[] {4,4,4,11,4,4,11,4,4,4,4,4}));
	}
}
