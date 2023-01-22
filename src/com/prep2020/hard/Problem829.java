package com.prep2020.hard;

public class Problem829 {
	public int consecutiveNumbersSum(int n) {
        int result = 1, sum = 0, i = 1, incr = 1;
        while (true) {
        	sum += i;
        	if (sum >= n) break;
        	i += incr;
        	if ((n - sum) % i == 0) result++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem829 problem = new Problem829();
		System.out.println(problem.consecutiveNumbersSum(5));
		System.out.println(problem.consecutiveNumbersSum(9));
		System.out.println(problem.consecutiveNumbersSum(15));
		System.out.println(problem.consecutiveNumbersSum(68));
	}
}
