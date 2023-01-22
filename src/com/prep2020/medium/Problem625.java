package com.prep2020.medium;

public class Problem625 {
	public int smallestFactorization(int num) {
        if (num < 10) return num;
        long result = 0, mult = 1;
        while(num > 9) {
        	boolean found = false;
        	for (int i = 9; i > 1; i--) {
        		if (num % i == 0) {
        			found = true;
        			num /= i;
        			result += mult * i;
        			break;
        		}
        	}
        	mult *= 10;
        	if (!found) return 0;
        }
        if (num > 1) result += mult * num;
        if (result > Integer.MAX_VALUE) return 0;
        return (int) result;
        
    }
}
