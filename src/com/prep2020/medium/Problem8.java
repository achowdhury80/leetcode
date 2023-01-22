package com.prep2020.medium;

public class Problem8 {
	public int myAtoi(String s) {
        s = s.trim();
        if ("".equals(s)) return 0;
        int sign = 1, i = 0;
        if (s.charAt(i) == '-') {
        	sign = -1;
        	i++;
        } else if (s.charAt(i) == '+') i++;
        int result = 0;
        for (; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (!Character.isDigit(c)) break;
        	int temp = result * 10 + (c - '0');
        	if (temp / 10 != result) 
				return sign < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        	else result = temp;
        }
        return sign * result;
    }
}
