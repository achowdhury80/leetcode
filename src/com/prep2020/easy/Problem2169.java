package com.prep2020.easy;

public class Problem2169 {
	public int countOperations(int num1, int num2) {
		if (num1 == 0 || num2 == 0) return 0;
        if (num1 == num2) return 1;
        if (num1 < num2) return countOperations(num2, num1);
        return (num1 / num2) + (num1 % num2 == 0? 0 : countOperations(num2, num1 % num2));
    }
}
