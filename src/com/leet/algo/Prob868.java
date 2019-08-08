package com.leet.algo;

public class Prob868 {
	public int binaryGap(int N) {
        int result = 0;
        int prev = -1;
        int i = -1;
        while(N > 0) {
        	i++;
        	if ((N & 1) == 1) {
        		if (prev == -1) prev = i;
        		else {
        			result = Math.max(result, i - prev);
        			prev = i;
        		}
        	}
        	N >>= 1;
        }
        return result;
    }
}
