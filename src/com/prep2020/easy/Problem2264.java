package com.prep2020.easy;

public class Problem2264 {
	public String largestGoodInteger(String num) {
        int result = -1;
        for (int i = 2; i < num.length(); i++) {
        	if (num.charAt(i) == num.charAt(i - 1) && num.charAt(i) == num.charAt(i - 2)) {
        		int digit = num.charAt(i) - '0';
        		if (digit > result) result = digit;
        	}
        }
        if (result == -1) return "";
        return "" + result + result + result;
    }
}
