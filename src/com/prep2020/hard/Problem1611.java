package com.prep2020.hard;

import java.util.*;

public class Problem1611 {

	int decToBinary(int n) {
		int[] binaryNum = new int[32];
		int i = 0;
		while (n > 0) {
			binaryNum[i] = n % 2;
			n = n / 2;
			i++;
		}
		int ans = 0, flag = 1;
		for (int j = i - 1; j >= 0; j--)
			if (binaryNum[j] == 1) {
				ans += flag * (((int)Math.pow(2, j + 1)) - 1);
				flag *= -1;
			}
		return ans;
	}

	int minimumOneBitOperations(int n) {
		return decToBinary(n);
	}

	public static void main(String[] args) {
		Problem1611 problem = new Problem1611();
		System.out.println(problem.minimumOneBitOperations(6));
	}
}
