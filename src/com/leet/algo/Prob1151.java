package com.leet.algo;

public class Prob1151 {
	public int minSwaps(int[] data) {
        int oneCount = 0;
        for (int d : data) if (d == 1) oneCount++;
        if (oneCount == data.length || oneCount < 2) return 0;
        int max = 0;
        for (int i = 0; i < oneCount; i++) {
        	max += data[i];
        }
        int cur = max;
        for (int i = oneCount; i < data.length; i++) {
        	cur = cur - data[i - oneCount] + data[i];
        	max = Math.max(max, cur);
        }
        return oneCount - max;
    }
}
