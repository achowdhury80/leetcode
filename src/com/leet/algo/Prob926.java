package com.leet.algo;

public class Prob926 {
	public int minFlipsMonoIncr(String S) {
        int prev_zero = 0, prev_one = 0;
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == '0') {
        		prev_one = 1 + Math.min(prev_zero, prev_one);
        	} else {
        		prev_one = Math.min(prev_zero, prev_one);
        		prev_zero = 1 + prev_zero;
        	}
        }
        
        return Math.min(prev_zero, prev_one);
    }
	
	public static void main(String[] args) {
		Prob926 prob = new Prob926();
		System.out.println(prob.minFlipsMonoIncr("00110"));
		System.out.println(prob.minFlipsMonoIncr("010110"));
		System.out.println(prob.minFlipsMonoIncr("00011000"));
		System.out.println(prob.minFlipsMonoIncr("10011111110010111011"));
	}
}
