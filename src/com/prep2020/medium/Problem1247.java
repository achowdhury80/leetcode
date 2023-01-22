package com.prep2020.medium;

public class Problem1247 {
	/**
	 * O(N)
	 * @param s1
	 * @param s2
	 * @return
	 */
	public int minimumSwap(String s1, String s2) {
		int[] arr1 = new int[2], arr2 = new int[2];
        for (int i = 0; i < s1.length(); i++) {
        	if (s1.charAt(i) != s2.charAt(i)) {
        		arr1[s1.charAt(i) - 'x']++;
        		arr2[s2.charAt(i) - 'x']++;
        	}
        }
        if ((arr1[0] + arr2[0]) % 2 != 0 || (arr1[1] + arr2[1]) % 2 != 0) return -1;
        int leftXX = Math.min(arr1[0], arr2[1]), rightXX = Math.min(arr2[0], arr1[1]);
        if (leftXX % 2 == 1) leftXX--;
        if (rightXX % 2 == 1) rightXX--;
        int result = (leftXX + rightXX) / 2;
        arr1[0] -= leftXX;
        arr2[1] -= leftXX;
        arr1[1] -= rightXX;
        arr2[0] -= rightXX;
        if (arr1[0] == 1) result += 2;
        return result;
    }
	
	public static void main(String[] args) {
		Problem1247 problem = new Problem1247();
		System.out.println(problem.minimumSwap("xx", "yy"));
		System.out.println(problem.minimumSwap("xx", "xy"));
	}
}
