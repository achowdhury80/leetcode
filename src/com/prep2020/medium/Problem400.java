package com.prep2020.medium;

public class Problem400 {
	public int findNthDigit(int n) {
	    int len = 1;
	    long count = 9;
	    int start = 1;
	    while(n > len * count){
	      n -= len * count;
	      len++;
	      count *= 10;
	      start *= 10;
	    }
	    start += (n - 1) / len;
	    String s = Integer.toString(start);
	    return Character.getNumericValue(s.charAt((n - 1) % len));
	  }
	
	public static void main(String[] args) {
		Problem400 problem = new Problem400();
		//System.out.println(problem.findNthDigit(11));
		System.out.println(problem.findNthDigit(100));
	}
}
