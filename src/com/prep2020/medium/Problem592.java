package com.prep2020.medium;

public class Problem592 {
	public String fractionAddition(String expression) {
        String result = "0/1";
        int i = 1;
        while(i < expression.length()) {
        	char c = expression.charAt(i);
        	if (c == '+' || c == '-') {
        		result = add(result, expression.substring(0, i));
        		expression = expression.substring(i);
        		i = 1;
        	} else i++;
        }
        result = add(result, expression);
        return result;
    }

	private String add(String fraction1, String fraction2){
		int[] f1 = fraction(fraction1);
		int[] f2 = fraction(fraction2);
	    int numer = f1[0] * f2[1] + f2[0] * f1[1];
	    int denom = f1[1] * f2[1];
	    int x = gcd(Math.abs(numer), denom);
	    return (numer / x) + "/" + (denom / x);
	  }
	
	private int[] fraction(String fraction) {
		int[] arr = new int[2];
		int idx;
		arr[0] = Integer.parseInt(fraction.substring(0, 
				(idx = fraction.indexOf("/"))));
		arr[1] = Integer.parseInt(fraction.substring(idx + 1));
		return arr;
	}
	
	private int gcd(int x, int y){
	    return x == 0 || y == 0 ? x + y : gcd(y, x% y);
	  }
}
