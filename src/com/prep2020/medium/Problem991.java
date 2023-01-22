package com.prep2020.medium;

public class Problem991 {
	public int brokenCalc(int startValue, int target) {
        int result = 0;
        while(target > startValue) {
        	if (target % 2 == 1) target++;
        	else target /= 2;
        	result++;
        }
        return result + startValue - target;
    }
}
