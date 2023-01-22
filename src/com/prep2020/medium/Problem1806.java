package com.prep2020.medium;

public class Problem1806 {
	public int reinitializePermutation(int n) {
       int i = 1;
       int[] perm = new int[n];
       for (int j = 0; j < n; j++) perm[j] = j;
       while(true) {
    	   int[] arr = new int[n];
    	   boolean flag = true;
    	   for (int j = 1; j < n - 1; j++) {
    		   if (j % 2 == 0) arr[j] = perm[j / 2];
    		   else arr[j] = perm[n / 2 + (j - 1) / 2];
    		   if (arr[j] != j) flag = false;
    	   }
    	   if (flag) return i;
    	   perm = arr;
    	   i++;
       }
    }
	
	public static void main(String[] args) {
		Problem1806 problem = new Problem1806();
		System.out.println(problem.reinitializePermutation(4));
	}
}
