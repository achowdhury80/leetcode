package com.prep2020.medium;

import java.util.HashMap;
import java.util.Map;

public class Problem166 {
	public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        boolean sign = !((numerator >= 0) ^ (denominator >= 0));
        String result = sign ? "" : "-";
        long numer = Math.abs((long)numerator);
        long denom = Math.abs((long)denominator);
        result += numer / denom;
        numer = numer % denom;
        if (numer > 0) result += ".";
        Map<Long, Integer> map = new HashMap<>();
        while(numer > 0) {
        	if (map.containsKey(numer)) {
        		int idx = map.get(numer);
        		return result.substring(0, idx) + "(" + result.substring(idx) + ")";
        	}
        	map.put(numer, result.length());
        	numer *= 10;
        	result += (numer / denom);
        	numer = numer % denom;
        }
        
        return result;
    }
}
