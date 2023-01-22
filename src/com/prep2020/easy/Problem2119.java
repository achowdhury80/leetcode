package com.prep2020.easy;

public class Problem2119 {
	public boolean isSameAfterReversals(int num) {
        if (num == 0) return true;
        return num % 10 != 0;
    }
}
