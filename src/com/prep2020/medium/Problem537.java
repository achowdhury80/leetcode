package com.prep2020.medium;

public class Problem537 {
	/*
	 * O(1)
	 */
	public String complexNumberMultiply(String a, String b) {
        int[] aComplex = parse(a), bComplex = parse(b);
        int[] mult = new int[] {aComplex[0] * bComplex[0] - aComplex[1] * bComplex[1], 
        		aComplex[0] * bComplex[1] + aComplex[1] * bComplex[0]};
        return "" + mult[0] + "+" + mult[1] + "i";
    }
	
	private int[] parse(String s) {
		int plusIndex = s.indexOf('+');
		return new int[] {Integer.parseInt(s.substring(0, plusIndex)),
				Integer.parseInt(s.substring(plusIndex + 1, s.length() - 1))};
	}
}
