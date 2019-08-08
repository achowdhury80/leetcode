package com.leet.algo;
public class Prob1010 {
	public int numPairsDivisibleBy60(int[] time) {
        int[] r = new int[60];
        for (int i = 0; i < time.length; i++) {
        	r[time[i] % 60]++;
        }
        int result = 0;
        for (int i = 1; i < 30; i++) {
        	result += r[i] * r[60 - i];
        }
        result += (r[0] * (r[0] - 1)) / 2;
        result += (r[30] * (r[30] - 1)) / 2;
        return result;
    }
}
