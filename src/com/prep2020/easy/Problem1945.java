package com.prep2020.easy;

public class Problem1945 {
	
	public int getLucky(String s, int k) {
        int val = 0;
        for (char c : s.toCharArray()) {
        	int num = (c - 'a') + 1;
        	if (num < 10) val += num;
        	else if (num < 20) {
        		val += (1 + (num % 10));
        	} else val += (2 + (num % 10));
        }
        for (int i = 1; i < k; i++) {
        	int newSum = 0;
        	if (val < 10) return val;
        	while(val > 0) {
        		newSum += (val % 10);
        		val /= 10;
        	}
        	val = newSum;
        }
        return val;
    }
	
	public static void main(String[] args) {
		Problem1945 problem = new Problem1945();
		System.out.println(problem.getLucky("leetcode", 2));
		
		System.out.println(problem.getLucky("iiii", 1));
	}
}
