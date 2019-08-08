package com.leet.algo;

public class Prob974 {
	public int subarraysDivByK(int[] A, int K) {
        int[] arr = new int[K];
        int sum = 0;
        int result = 0;
        for (int a : A) {
        	sum += a;
        	if (sum % K == 0) result++;
        	result += arr[((sum % K) + K) % K]++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob974 prob = new Prob974();
		System.out.println(prob.subarraysDivByK(new int[] {4, 5, 0, -2, -3, 1}, 5));
	}
}
