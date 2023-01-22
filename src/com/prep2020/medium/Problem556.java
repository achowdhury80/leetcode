package com.prep2020.medium;

public class Problem556 {
	public int nextGreaterElement(int n) {
        char[] arr = ("" + n).toCharArray();
        int len =arr.length;
        for (int i = len - 2; i > -1; i--) {
        	if (arr[i] < arr[i + 1]) {
        		int j = i + 1;
        		for (; j < len; j++) {
        			if (arr[j] <= arr[i]) break;
        		}
        		j--;
        		swap(arr, i, j);
        		reverse(arr, i + 1, len - 1);
        		long l = Long.parseLong(new String(arr));
        		if (l > Integer.MAX_VALUE) return -1;
        		return (int)l;
        	}
        	
        }
        
        return -1;
    }

	private void reverse(char[] arr, int i, int j) {
		while(i < j) {
			swap(arr, i, j);
			i++;
			j--;
		}
		
	}

	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		Problem556 problem = new Problem556();
		System.out.println(problem.nextGreaterElement(12443322));
	}
}
