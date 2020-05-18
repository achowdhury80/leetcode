package com.leet.algo;

public class Prob1015 {
	public int smallestRepunitDivByK(int K) {
		if(K % 2 == 0 || K % 5 == 0) return -1;
        int n = 0;
        for(int i = 1; i < K + 1; i++){
        	// if n = km + r then n* 10 + 1= 10km + 10r + 1
        	// we need to chek if 10r + 1 divisible by k
        	// try max k times, since there can be max k - 1 reminders
        	// after k times cycle will start
            n = (n * 10 + 1) % K;
            if(n == 0){
                return i;
            }
        }
        return -1;
    }
}
