package com.prep2020.medium;

public class Problem777 {
	public boolean canTransform(String start, String end) {
        if (start.length() != end.length()) return false;
        int i = 0, j = 0, n = start.length();
        while(i < n && j < n) {
        	if (start.charAt(i) == 'X') {
        		i++;
        		continue;
        	}
        	if (end.charAt(j) == 'X') {
        		j++;
        		continue;
        	}
        	if (start.charAt(i) != end.charAt(j)) return false;
        	if (start.charAt(i) == 'L' && i < j || start.charAt(i) == 'R' && i > j) 
        		return false;
        	i++;
        	j++;
        }
        while(i < n && start.charAt(i) == 'X')
        	i++;
        while(j < n && end.charAt(j) == 'X')
        	j++;
        return i == n && j == n;
    }
}
