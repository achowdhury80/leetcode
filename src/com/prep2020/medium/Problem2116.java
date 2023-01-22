package com.prep2020.medium;

public class Problem2116 {
	public boolean canBeValid(String s, String locked) {
        int n = s.length();
        if (n % 2 == 1) return false;
        int val = 0, open = 0;
        for (int i = 0; i < n; i++) {
        	if(locked.charAt(i) == '0') {
        		open++;
        		continue;
        	}
        	char c1 = s.charAt(i);
        	
        	if (c1 == '(') val++;
        	else val--;
        	if (val < 0) {
        		if (open < 1) return false;
        		open--;
        		val++;
        	}
        }
        
        val = 0; 
        open = 0;
        for (int i = n - 1; i > -1; i--) {
        	if(locked.charAt(i) == '0') {
        		open++;
        		continue;
        	}
        	char c1 = s.charAt(i);
        	
        	if (c1 == ')') val++;
        	else val--;
        	if (val < 0) {
        		if (open < 1) return false;
        		open--;
        		val++;
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		Problem2116 problem = new Problem2116();
		System.out.println(problem.canBeValid("))()))", "010100"));
	}
}
