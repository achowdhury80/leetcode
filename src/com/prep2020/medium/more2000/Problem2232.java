package com.prep2020.medium.more2000;

public class Problem2232 {
	public String minimizeResult(String expression) {
        int plusIndex = -1, n = expression.length();
        for (int i = 0; i < n; i++) {
        	if (expression.charAt(i) == '+') {
        		plusIndex = i;
        		break;
        	}
        }
        int minVal = Integer.MAX_VALUE;
        String result = "";
        for (int i = plusIndex - 1; i > -1; i--) {
        	for (int j = plusIndex + 1; j < n; j++) {
        		int left = 1, middleleft = 0, middleRight = 0, right = 1;
        		if (expression.charAt(i) == '0') continue;
        		middleleft = Integer.parseInt(expression.substring(i, plusIndex));
        		middleRight = Integer.parseInt(expression.substring(plusIndex + 1, j + 1));
        		if (i > 0) left = Integer.parseInt(expression.substring(0, i));
        		if (j < n - 1) right = Integer.parseInt(expression.substring(j + 1));
        		int val = left * (middleleft + middleRight) * right;
        		if (val < minVal) {
        			minVal = val;
        			result = expression.substring(0, i) + "(" + expression.substring(i, j + 1) + ")" + expression.substring(j + 1);
        		}
        	}
        }
        return result;
    }
}
