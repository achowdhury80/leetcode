package com.leet.algo;
import java.util.*;
public class Prob856 {
	public int scoreOfParentheses(String S) {
        Stack<Integer> s = new Stack<>();
        char[] arr = S.toCharArray();
        for (char c : arr) {
        	if (c == '(') s.push(-1);
        	else {
        		int val = 0, temp;
        		while((temp = s.pop()) != -1) {
        			val += temp;
        		}
        		s.push(val == 0 ? 1 : val * 2);
        	}
        }
        int result = s.pop();
        while(!s.isEmpty()) result += s.pop();
        return result;
    }
}
