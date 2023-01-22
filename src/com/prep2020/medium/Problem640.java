package com.prep2020.medium;

public class Problem640 {
	public String solveEquation(String equation) {
		int equalIndex = equation.indexOf('=');
        int[] lhs = findXandVal(equation.substring(0, equalIndex).trim());
        int[] rhs = findXandVal(equation.substring(equalIndex + 1).trim());
        if (lhs[0] == rhs[0]) {
        	if (lhs[1] == rhs[1]) return "Infinite solutions";
        	return "No solution";
        }
        int xCoefficient = lhs[0] - rhs[0], val = rhs[1] - lhs[1];
        return "x=" + (val / xCoefficient);
    }
	
	
	private int[] findXandVal(String s) {
		int xCoefficient = 0, val = 0, n = s.length();
		String token = "";
		for (int i = 0; i < n; i++) {
        	char c = s.charAt(i);
        	if (c == ' ' || c == '+' || c == '-') {
        		int tokenVal = evaluate(token);
        		if (token.indexOf('x') > -1) xCoefficient += tokenVal;
        		else val += tokenVal;
        		if (c == '-') token = "-";
        		else token = "";
        	} else token += c;
        }
		if (!token.equals("")) {
			int tokenVal = evaluate(token);
    		if (token.indexOf('x') > -1) xCoefficient += tokenVal;
    		else val += tokenVal;
		}
		return new int[] {xCoefficient, val};
	}
	
	private int evaluate(String token) {
		if ("".equals(token)) return 0;
		int sign = 1, result = 0;
		if (token.charAt(0) == '-') {
			sign *= -1;
			token = token.substring(1);
		}
		if (token.indexOf('x') > -1) {
			if (token.length() > 1) result += sign 
					* Integer.parseInt(token.substring(0, token.length() - 1));
			else result += sign;
		} else result += sign * Integer.parseInt(token);
		return result;
	}
	
	public static void main(String[] args){
	    Problem640 prob640 = new Problem640();
	    System.out.println(prob640.solveEquation("x+5-3+x=6+x-2"));
	    /*System.out.println(prob640.solveEquation("x=x"));
	    System.out.println(prob640.solveEquation("2x=x"));
	    System.out.println(prob640.solveEquation("2x+3x-6x=x+2"));
	    System.out.println(prob640.solveEquation("x=x+2"));*/
	  }
}
