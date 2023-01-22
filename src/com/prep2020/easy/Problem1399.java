package com.prep2020.easy;

public class Problem1399 {
	/**
	 * O(N)
	 * @param n
	 * @return
	 */
	public int countLargestGroup(int n) {
        int[] arr = new int[37];
        for (int i = 1; i <= n; i++) {
        	int sum = dSum(i);
        	arr[sum]++;
        }
        int max = -1, result = 0;
        for (int i = 0; i < 37; i++) {
        	if (arr[i] > max) {
        		max = arr[i];
        		result = 1;
        	} else if (arr[i] == max) result++;
        }
        return result;
    }
	
	private int dSum(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
	
	public static void main(String[] args) {
		Problem1399 problem = new Problem1399();
		System.out.println(problem.countLargestGroup(13));
	}
}
