package com.prep2020.medium;
import java.util.*;
public class Problem1291 {
	public List<Integer> sequentialDigits(int low, int high) {
        int cur = 1, maxDigit = 1, minDigit = (int)Math.log10(low);
        if (Math.pow(10, minDigit) < low) minDigit++;
        while(cur * 10 <= high) {
        	maxDigit++;
        	cur *= 10;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = minDigit; i <= maxDigit; i++) {
        	for (int j = 1; j < 10; j++) {
        		int num = 0, digits = 0, k = j;
        		while(digits < i && k < 10) {
        			num = num * 10 + k;
        			digits++;
        			k++;
        		}
        		if (digits == i && num >= low && num <= high) result.add(num);
        		if (num >= high) break;
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1291 problem = new Problem1291();
		System.out.println(problem.sequentialDigits(58, 155));
	}
}
