package com.leet.algo;

public class Prob1067 {
	public int digitsCount(int d, int low, int high) {
        return count(high, d) - count(low - 1, d);
    }
	
	private int count(int n, int d) {
		if (n == 0) return 0;
		if (d == 0 && n < 10) return 0;
		int result = 0;
		for (int divisor = 10; divisor <= n; divisor *= 10) {
			int quo = n / divisor;
			result += quo;
			if (quo * divisor + (d * (divisor/10)) <= n) result++;
		}
		return result;
	}
	
	public static void main(String[] args) {
		Prob1067 prob = new Prob1067();
		System.out.println(prob.digitsCount(1, 1, 13));
	}
}
