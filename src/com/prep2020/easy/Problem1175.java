package com.prep2020.easy;

public class Problem1175 {
	public int numPrimeArrangements(int n) {
        boolean[] notPrime = new boolean[n + 1];
        notPrime[1] = true;
        int count = 0;
        for (int i = 2; i <= n; i++) {
        	if (!notPrime[i]) {
        		count++;
        		for (int j = 2; i * j <= n; j++) {
        			notPrime[i * j] = true;
        		}
        	}
        }
        return (int)((fact(count) * fact(n - count)) % ((int)(1e9 + 7)));
    }
	
	private long fact(int n) {
		if (n < 2) return 1;
		return (1l * n * fact(n - 1)) % ((int)(1e9 + 7));
	}
	
	public static void main(String[] args) {
		Problem1175 problem = new Problem1175();
		System.out.println(problem.numPrimeArrangements(5));
	}
}
