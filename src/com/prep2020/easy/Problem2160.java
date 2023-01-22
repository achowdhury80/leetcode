package com.prep2020.easy;

import java.util.Arrays;

public class Problem2160 {
	public int minimumSum(int num) {
        char[] arr = new char[4];
        int idx = 0;
        while(num > 0) {
        	arr[idx++] = (char)('0' + (num % 10));
        	num /= 10;
        }
        Arrays.sort(arr);
        int num1 = Integer.parseInt("" + (arr[0] == '0' ? "" : arr[0]) 
        		+ arr[2]), num2 = Integer.parseInt("" + (arr[1] == '0' ? "" : arr[1]) 
        				+ arr[3]);
        return num1 + num2;
    }
	
	public static void main(String[] args) {
		Problem2160 problem = new Problem2160();
		System.out.println(problem.minimumSum(2932));
	}
}
