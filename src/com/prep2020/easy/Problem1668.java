package com.prep2020.easy;

public class Problem1668 {
	public int maxRepeating(String sequence, String word) {
        int result = -1;
        String cur = "";
        while (sequence.contains(cur)) {
        	result++;
        	cur += word;
        }
        return result;
    }
}
