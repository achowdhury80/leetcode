package com.prep2020.medium;

public class Problem165 {
	/**
	 * O(N)
	 * @param version1
	 * @param version2
	 * @return
	 */
	public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\."), arr2 = version2.split("\\.");
        for (int i = 0; i < Math.max(arr1.length, arr2.length); i++) {
        	int v1 = 0, v2 = 0;
        	if (i < arr1.length) v1 = Integer.parseInt(arr1[i]);
        	if (i < arr2.length) v2 = Integer.parseInt(arr2[i]);
        	if (v1 > v2) return 1;
        	else if (v1 < v2) return -1;
        }
        return 0;
    }
	
	public static void main(String[] args) {
		Problem165 problem = new Problem165();
		System.out.println(problem.compareVersion("0.1", "1.1"));
	}
}
