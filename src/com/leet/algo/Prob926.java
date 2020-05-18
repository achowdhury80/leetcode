package com.leet.algo;

public class Prob926 {
	public int minFlipsMonoIncr(String S) {
        int flipToZero = 0, flipToOne = 0;
        char[] arr = S.toCharArray();
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == '0') {
        		flipToOne = 1 + Math.min(flipToZero, flipToOne);
        	} else {
        		flipToOne = Math.min(flipToZero, flipToOne);
        		flipToZero = 1 + flipToZero;
        	}
        }
        
        return Math.min(flipToZero, flipToOne);
    }
	
	public static void main(String[] args) {
		Prob926 prob = new Prob926();
		System.out.println(prob.minFlipsMonoIncr("00110"));
		System.out.println(prob.minFlipsMonoIncr("010110"));
		System.out.println(prob.minFlipsMonoIncr("00011000"));
		System.out.println(prob.minFlipsMonoIncr("10011111110010111011"));
	}
}
