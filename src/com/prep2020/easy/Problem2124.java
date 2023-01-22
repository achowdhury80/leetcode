package com.prep2020.easy;

public class Problem2124 {
	public boolean checkString(String s) {
		boolean bFound = false;
        for (char c : s.toCharArray()) {
        	if (!bFound && c == 'b') bFound = true;
        	else if (bFound && c == 'a') return false;
        }
        return true;
    }
}
