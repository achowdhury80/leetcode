package com.prep2020.medium;

public class Problem1497 {
	/**
	 * O(N)
	 * @param arr
	 * @param k
	 * @return
	 */
	public boolean canArrange(int[] arr, int k) {
        int[] rem = new int[k];
        for (int num : arr) {
        	int r = ((num % k) + k) % k;
        	rem[r]++;
        }
        if (rem[0] % 2 == 1) return false;
        for (int i = 1; 2 * i < k; i++) {
        	if (rem[i] != rem[k - i]) return false;
        }
        if (k % 2 == 0 && rem[k / 2] == 1) return false;
        return true;
    }
	
	public static void main(String[] args) {
		Problem1497 prob = new Problem1497();
		System.out.println(prob.canArrange(new int[] {8, 6, 3, 3}, 5));
	}
}
