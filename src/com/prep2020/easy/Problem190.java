package com.prep2020.easy;

public class Problem190 {
	public int reverseBits(int n) {
		int result = 0;
        for (int i = 0; i < 32; i++) {
        	result = (result  << 1) | ((n >> i) & 1);
        }
        return result;
    }
}
