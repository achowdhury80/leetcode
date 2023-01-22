package com.prep2020.medium;

public class Problem1535 {
	public int getWinner(int[] arr, int k) {
		int won = 0, i = 0, n = arr.length;
        while(i < n) {
        	if (i == n - 1) return arr[n - 1];
        	int j = i + 1;
        	while(j <= Math.min(n - 1, i + k - won)) {
        		if (arr[i] < arr[j]) {
        			won = 1;
        			i = j;
        			break;
        		}
        		j++;
        	}
        	if (j == n || j == i + 1 + k - won) return arr[i];
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Problem1535 problem = new Problem1535();
		System.out.println(problem.getWinner(new int[] {2, 1, 3,5, 4, 6, 7}, 2));
	}
}
