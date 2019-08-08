package com.leet.algo;

public class Prob1009 {
	public int bitwiseComplement(int N) {
        if (N == 0) return 1;
        int result = 0;
        int i = 0;
        while (N > 0) {
        	result |= (((N & 1) ^ 1) << i);
        	N >>= 1;
        	i++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1009 prob = new Prob1009();
		System.out.println(prob.bitwiseComplement(5));
	}
}
