package com.prep2020.medium;

public class Problem1055 {
	public int shortestWay(String source, String target) {
		int result = 1, j = -1;
		char[] sourceArr = source.toCharArray();
        for (char c : target.toCharArray()) {
        	boolean found = false;
        	for (int k = j + 1; k < source.length(); k++) {
        		if (sourceArr[k] == c) {
        			j = k;
        			found = true;
        			break;
        		}
        	}
        	if (!found && j > -1) {
        		for (int k = 0; k <= j; k++) {
        			if (sourceArr[k] == c) {
        				j = k;
        				result++;
        				found = true;
        				break;
        			}
        		}
        	}
        	if (!found) return -1;
        }
        return result;
    }
}
