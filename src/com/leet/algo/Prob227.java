package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob227 {
	public int calculate(String s) {
        if (s == null || (s = s.trim()).length() == 0) return 0;
        int result = 0, sign = 1;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
        	if (c == ' ') continue;
        	if (c == '+' || c == '-') {
        		result += sign * evaluate(sb);
        		sign = c == '+' ? 1 : -1;
        		sb = new StringBuilder();
        	} else {
        		sb.append(c);
        	}
        }
        result += sign * evaluate(sb);
        return result;
    }
	
	private int evaluate(StringBuilder sb) {
		if (sb.length() == 0) return 0;
		int result = 1, num = 0;
		char operator = '*';
		for (char c : sb.toString().toCharArray()) {
			if (c == '*' || c == '/') {
				if (operator == '*') result *= num;
				else result /= num;
				num = 0;
				operator = c;
			} else num = num * 10 + (c - '0');
		}
		if (operator == '*') result *= num;
		else result /= num;
		return result;
	}
}
