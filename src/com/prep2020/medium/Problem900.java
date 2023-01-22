package com.prep2020.medium;

public class Problem900 {
	private int curIndex;
	private int[] encoding;
	public Problem900(int[] encoding) {
        this.encoding = encoding;
    }
    
    public int next(int n) {
    	int result = -1;
    	while(true) {
	        if (encoding[curIndex] >= n) {
	        	encoding[curIndex] -= n;
	        	result = encoding[curIndex + 1];
	        	return result;
	        }
	        n -= encoding[curIndex];
	        encoding[curIndex] = 0;
	        if (curIndex + 2 == encoding.length) return result;
	        curIndex += 2;
    	}
    }
    
    public static void main(String[] args) {
    	Problem900 problem = new Problem900(new int[] {3,8,0,9,2,5});
    	System.out.println(problem.next(2));
    	System.out.println(problem.next(1));
    	System.out.println(problem.next(1));
    	System.out.println(problem.next(2));
    }
}
