package com.prep2020.easy;

public class Problem1427 {
	public String stringShift(String s, int[][] shift) {
        int[] totalShift = new int[2];
        for (int[] move : shift) {
        	if (move[0] == totalShift[0]) totalShift[1] += move[1];
        	else {
        		if (move[1] <= totalShift[1]) totalShift[1] -= move[1];
        		else {
        			totalShift[0] = move[0];
        			totalShift[1] = move[1] - totalShift[1];
        		}
        	}
        }
        totalShift[1] %= s.length();
        if (totalShift[1] == 0) return s;
        if (totalShift[0] == 0) {
        	return s.substring(totalShift[1]) + s.substring(0, totalShift[1]);
        }
        return s.substring(s.length() - totalShift[1]) 
        		+ s.substring(0, s.length() - totalShift[1]);
    }
}
