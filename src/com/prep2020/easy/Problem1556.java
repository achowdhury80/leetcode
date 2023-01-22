package com.prep2020.easy;

public class Problem1556 {
	public String thousandSeparator(int n) {
        if (n < 1000) return "" + n;
        String result = "";
        int count = 0;
        while(n > 0) {
        	count++;
        	if (count == 4) {
        		result = "." + result;
        		count = 1;
        	}
        	result = (n % 10) + result;
        	n /= 10;
        }
        return result;
    }
}
