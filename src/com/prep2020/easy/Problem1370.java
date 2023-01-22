package com.prep2020.easy;

public class Problem1370 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public String sortString(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) arr[c - 'a']++;
        StringBuilder sb = new StringBuilder();
        int count = s.length();
        while(count > 0) {
        	//increasing 
        	for (int i = 0; i < 26; i++) {
        		if (arr[i] > 0) {
        			sb.append((char)('a' + i));
        			arr[i]--;
        			count--;
        		}
        	}
        	for (int i = 25; i > -1; i--) {
        		if (arr[i] > 0) {
        			sb.append((char)('a' + i));
        			arr[i]--;
        			count--;
        		}
        	}
        }
        return sb.toString();
    }
}
