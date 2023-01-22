package com.prep2020.medium;

public class Problem822 {
	public int flipgame(int[] fronts, int[] backs) {
        boolean[] arr = new boolean[2001];
        for (int i = 0; i < fronts.length; i++) {
        	if (fronts[i] == backs[i]) arr[fronts[i]] = true;
        }
        int result = 0;
        for (int i : fronts) {
        	if (!arr[i]) {
        		if (result == 0 || result > i) result = i;
        	}
        }
        for (int i : backs) {
        	if (!arr[i]) {
        		if (result == 0 || result > i) result = i;
        	}
        }
        return result;
    }
}
