package com.prep2020.medium;

public class Problem1850 {
	public int getMinSwaps(String num, int k) {
        char[] arr = num.toCharArray();
        for (int i = 0; i < k; i++) {
        	findNextPermutation(arr);
        }
        char[] original = num.toCharArray();
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == original[i]) continue;
        	for (int j = i + 1; j < arr.length; j++) {
        		if (arr[i] == original[j]) {
        			result += (j - i);
        			for (; j > i; j--) swap(original, j, j - 1);
        			break;
        		}
        	}
        }
        return result;
    }
	
	private void findNextPermutation(char[] arr) {
		int n = arr.length;
		for (int i = n - 2; i > -1; i--) {
			if (arr[i] < arr[i + 1]) {
				for (int k = n - 1; k > i; k--) {
					if (arr[k] > arr[i]) {
						swap(arr, i, k);
						reverse(arr, i + 1, n - 1);
						return;
					}
				}
			}
		}
	}
	
	private void reverse(char[] arr, int i, int j) {
		while(i < j) swap(arr, i++, j--);
	}
	
	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	
	public static void main(String[] args) {
		Problem1850 problem = new Problem1850();
		System.out.println(problem.getMinSwaps("5489355142", 4));
	}
}
