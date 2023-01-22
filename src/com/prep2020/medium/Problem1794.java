package com.prep2020.medium;

public class Problem1794 {
	public int countQuadruples(String firstString, String secondString) {
        int[] arr1 = new int[26], arr2 = new int[26];
        for (int i = 0; i < 26; i++) {
        	arr1[i] = -1;
        	arr2[i] = -1;
        }
        for (int i = 0; i < firstString.length(); i++) {
        	int idx = firstString.charAt(i) - 'a';
        	if (arr1[idx] == -1) arr1[idx] = i;
        }
        
        for (int i = secondString.length() - 1; i > -1; i--) {
        	int idx = secondString.charAt(i) - 'a';
        	if (arr2[idx] == -1) arr2[idx] = i;
        }
        int[] result = new int[2];
        for (int i = 0; i < 26; i++) {
        	if (arr1[i] > -1 && arr2[i] > -1) {
        		int val = arr1[i] - arr2[i];
        		if (result[1] == 0 || result[0] > val) {
        			result = new int[] {val, 1};
        		} else if (result[0] == val) result[1]++;
        	}
        }
        return result[1];
    }
	
	public static void main(String[] args) {
		Problem1794 problem = new Problem1794();
		System.out.println(problem.countQuadruples("abc", "abc"));
	}
}
