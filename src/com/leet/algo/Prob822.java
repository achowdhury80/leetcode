package com.leet.algo;
public class Prob822 {
	public int flipgame(int[] fronts, int[] backs) {
        int[] nums = new int[2001];
        for (int i = 0; i < fronts.length; i++) {
        	int numF = fronts[i];
        	int numB = backs[i];
        	if(numF == numB) nums[numF] = -1;
        	else {
        		if (nums[numF] != -1) nums[numF] = 1;
        		if (nums[numB] != -1) nums[numB] = 1;
        	}
        }
        for (int i = 1; i < 2001; i++) {
        	if (nums[i] == 1) return i;
        }
        return 0;
    }
}
