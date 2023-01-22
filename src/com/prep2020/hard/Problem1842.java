package com.prep2020.hard;

public class Problem1842 {
	public String nextPalindrome(String num) {
        int n = num.length();
        if (n < 4) return "";
        String firstPart = num.substring(0, n / 2);
        String nextNum = findNextNum(firstPart);
        if (nextNum.equals(firstPart)) return "";
        return nextNum +(n % 2 == 0 ? "" : num.charAt(n / 2)) + new StringBuilder(nextNum).reverse().toString();
    }

	private String findNextNum(String firstPart) {
		char[] arr = firstPart.toCharArray();
		for (int i = arr.length - 2; i > -1; i--) {
			if (arr[i] < arr[i + 1]) {
				int last = i + 1;
				for (int j = i + 2; j < arr.length; j++) {
					if (arr[j] > arr[i]) last = j;
					else break;
;				}
				swap(arr, i, last);
				reverse(arr, i + 1, arr.length - 1);
				break;
			}
		}
		return new String(arr);
	}
	
	private void reverse(char[] arr, int start, int end) {
		if (start >= end) return;
		while(start < end) {
			swap(arr, start++, end--);
		}
	}
	
	private void swap(char[] arr, int i, int j) {
		char temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		Problem1842 problem = new Problem1842();
		System.out.println(problem.nextPalindrome("1221"));
		System.out.println(problem.nextPalindrome("45544554"));
	}
}
