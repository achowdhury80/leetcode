package com.prep2020.medium.more2000;

public class Problem2222 {
	public long numberOfWays(String s) {
        int[] left = new int[2], right = new int[2];
        int n = s.length();
        int idx = -1;
        for (int i = 1; i < n; i++) {
        	idx = s.charAt(i) - '0';
        	right[idx]++;
        }
        left[s.charAt(0) - '0']++;
        long result = 0;
        for (int i = 1; i < n - 1; i++) {
        	idx = s.charAt(i) - '0';
        	right[idx]--;
        	int other = (idx + 1) % 2;
        	result += (1l * left[other]) * right[other];
        	left[idx]++;
        }
        
        return result;		
    }
}
