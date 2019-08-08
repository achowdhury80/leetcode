package com.leet.algo;
import java.util.*;
public class Prob902 {
	public int atMostNGivenDigitSet(String[] D, int N) {
        int d = D.length;
        int x = N;
        List<Integer> list = new ArrayList<>();
        while(x > 0) {
        	list.add(0, x % 10);
        	x /= 10;
        }
        int result = 0;
        int[] dp = new int[list.size() + 1];
        dp[0] = 1;
        for (int i = 1; i < list.size(); i++) {
        	int prod = 1;
        	for (int j = 1; j <= i; j++) {
        		prod *= d;
        	}
        	result += prod;
        	dp[i] = prod;
        }
        result += count(list, D, 0, dp);
        return result;
    }
	
	private int count(List<Integer> list, String[] D, int startIndex, int[] dp) {
		int result = 0;
		if (startIndex >= list.size()) return 1;
		int num = list.get(startIndex);
    	for (int j = 0; j < D.length; j++) {
    		int digit = D[j].charAt(0) - '0';
    		if (digit < num) {
    			result += dp[list.size() - startIndex - 1];
    		} else if (digit == num) {
    			result += count(list, D, startIndex + 1, dp);
    		} else break;
    	}
    	return result;
	}
	
	public static void main(String[] args) {
		Prob902 prob = new Prob902();
		//System.out.println(prob.atMostNGivenDigitSet(new String[] {"3","4","8"}, 4));
		System.out.println(prob.atMostNGivenDigitSet(new String[] {"5","7","8"}, 59));
	}
	
	
}
