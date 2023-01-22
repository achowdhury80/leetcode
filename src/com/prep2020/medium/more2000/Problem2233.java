package com.prep2020.medium.more2000;

public class Problem2233 {
	public int maximumProduct(int[] nums, int k) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        int[] arr = new int[1100001];
        for (int i : nums) {
        	arr[i]++;
        	min = Math.min(min, i);
        	max = Math.max(max, i);
        }
        for (int i = 0; i < k; i++) {
        	arr[min]--;
        	arr[min + 1]++;
        	if (min + 1 > max) max = min + 1;
        	if (arr[min] == 0) min++;
        }
        long result = 1, mod = (long)(1e9 + 7);
        for (int i = min; i <= max; i++) {
        	if (arr[i] == 0) continue;
        	long prod = 1;
        	for (int j = 0; j < arr[i]; j++) {
        		prod = (prod * (1l * i)) % mod;
        	}
        	result = (result * prod) % mod;
        }
        return (int) result;
    }
	
	public static void main(String[] args) {
		Problem2233 problem = new Problem2233();
		System.out.println(problem.maximumProduct(new int[] {0, 4}, 5));
		System.out.println(problem.maximumProduct(new int[] {6, 3, 3, 2}, 2));
	}
}
