package com.leet.algo;
public class Prob1134 {
	public boolean isArmstrong(int N) {
		long result = 0;
		int a = N;
		int power = String.valueOf(N).length();
        while (a > 0) {
        	result += Math.pow(a % 10, power);
        	a /= 10;
        }
        return N == result;
    }
}
