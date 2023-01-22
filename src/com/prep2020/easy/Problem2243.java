package com.prep2020.easy;

public class Problem2243 {
	public String digitSum(String s, int k) {
		int n = s.length();
        if (n <= k) return s;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i+= k) {
        	int sum = 0;
        	for (int j = i; j < Math.min(n, i + k); j++) sum += (int)(s.charAt(j) - '0');
        	sb.append(sum);
        }
        return digitSum(sb.toString(), k);
    }
	
	public static void main(String[] args) {
		Problem2243 problem = new Problem2243();
		System.out.println(problem.digitSum("11111222223", 3));
	}
}
