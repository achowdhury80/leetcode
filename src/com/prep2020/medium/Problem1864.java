package com.prep2020.medium;

public class Problem1864 {
	public int minSwaps(String s) {
		int n = s.length();
        int startZeroDiff = 0, startOneDiff = 0, zeroCount = 0;
        char curStartWithZero = '0', curStartWithOne = '1';
        for (int i = 0; i < n; i++) {
        	if (s.charAt(i) == '0') zeroCount++;
        	if (s.charAt(i) != curStartWithZero) startZeroDiff++;
        	if (s.charAt(i) != curStartWithOne) startOneDiff++;
        	curStartWithZero = curStartWithZero == '0' ? '1' : '0';
        	curStartWithOne = curStartWithOne == '0' ? '1' : '0';
        }
        if (Math.abs(2 * zeroCount - n) > 1) return -1;
        return Math.min(startZeroDiff % 2 == 0 ? startZeroDiff / 2 : Integer.MAX_VALUE, startOneDiff % 2 == 0 ? startOneDiff / 2 : Integer.MAX_VALUE);
    }
}
