package com.leet.algo;

public class Prob1017 {
	public String baseNeg2(int N) {
		int a = 1;
		while(a < N) a = (a << 2) + 1;
		return Integer.toBinaryString(a ^ (a - N));
    }
	
	public static void main(String[] args) {
		Prob1017 prob = new Prob1017();
		System.out.println(prob.baseNeg2(2));
		System.out.println(prob.baseNeg2(10));
	}
}
