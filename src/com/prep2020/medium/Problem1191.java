package com.prep2020.medium;
public class Problem1191 {
	public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0, mod = (long)(1e9 + 7);
        boolean negativeExists = false;
        for (int i : arr) {
        	sum += i;
        	if (i < 0) negativeExists = true;
        }
        if (!negativeExists) return (int)((sum * k) % mod);
        long result = 0;
        long singleArrMax = findArrMax(arr);
        result = Math.max(result, singleArrMax);
        if (k == 1) return (int)(result % mod);
        int[] doubleArray = new int[2 * arr.length];
        for (int i = 0; i < arr.length; i++) {
        	doubleArray[i] = arr[i];
        	doubleArray[arr.length + i] = arr[i];
        }
        long doubleArrMax = findArrMax(doubleArray);
        result = Math.max(result, doubleArrMax);
        if (k == 2) return (int)(result % mod);
        if (sum > 0) result = Math.max(result, doubleArrMax + sum * (k - 2));
        return (int)(result % mod);
        
    }

	private long findArrMax(int[] arr) {
		int lowest = 0, sum = 0, result = 0;
		for (int i : arr) {
			sum += i;
			result = Math.max(result, sum - lowest);
			lowest = Math.min(lowest, sum);
		}
		return result;
	}
	
	
	public static void main(String[] args) {
		Problem1191 problem = new Problem1191();
		System.out.println(problem.kConcatenationMaxSum(new int[] {1, -2, 1}, 5));
	}
}
