package com.prep2020.hard;

public class Problem135 {
	public int candy(int[] ratings) {
        int i = 0, n = ratings.length;
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) arr[j] = 1;
        while(i < n) {
        	if (minima(ratings, i)) {
        		i = adjust(ratings, arr, i);
        	} else i++;
        }
        int result = 0;
        for (int j : arr) result += j;
        return result;
    }

	private int  adjust(int[] ratings, int[] arr, int i) {
		arr[i] = 1;
		int n = ratings.length;
		int maxPos = i;
		for (int j = i + 1; j < n; j++) {
			if (ratings[j] > ratings[j - 1]) {
				if (arr[j] > arr[j - 1]) break;
				else {
					arr[j] = arr[j - 1] + 1;
					maxPos = j;
				}
			} else {
				maxPos = j - 1;
				break;
			}
		}
		for (int j = i - 1; j > -1; j--) {
			if (ratings[j] > ratings[j + 1]) {
				if (arr[j] > arr[j + 1]) break;
				else arr[j] = arr[j + 1] + 1;
			} else break;
		}
		return maxPos + 1;
	}

	private boolean minima(int[] ratings, int i) {
		if (i > 0 && ratings[i] > ratings[i - 1]) return false;
		int n = ratings.length;
		if (i < n - 1 && ratings[i] > ratings[i + 1]) return false;
		if (i > 0 && ratings[i] < ratings[i - 1]) return true;
		if (i < n - 1 && ratings[i] < ratings[i + 1]) return true;
		return false;
	}
	
	public static void main(String[] args) {
		Problem135 problem = new Problem135();
		System.out.println(problem.candy(new int[] {1, 0, 2}));
		System.out.println(problem.candy(new int[] {1, 2, 2}));
	}
}
