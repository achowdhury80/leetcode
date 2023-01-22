package com.prep2020.easy;

public class Problem2220 {
	public int minBitFlips(int start, int goal) {
        return Integer.bitCount(start ^ goal);
    }
}
