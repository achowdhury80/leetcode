package com.leet.algo;

public class Prob1188 {
	public int numberOfDays(int Y, int M) {
        if(M == 2) {
        	if(Y % 4 == 0 && (Y % 100 != 0 || Y % 400 == 0)) return 29;
        	return 28;
        } else if (M == 4 || M == 6 || M == 9 || M == 11) return 30;
        return 31;
    }
}
