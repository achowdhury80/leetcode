package com.prep2020.easy;
import java.util.*;
public class Problem1742 {
	public int countBalls(int lowLimit, int highLimit) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for (int i = lowLimit; i <= highLimit; i++) {
        	int sum = findSum(i);
        	map.put(sum, map.getOrDefault(sum,  0) + 1);
        	result = Math.max(result, map.get(sum));
        }
        return result;
    }
	
	private int findSum(int n) {
		int sum = 0;
		while(n > 0) {
			sum += n % 10;
			n /= 10;
		}
		return sum;
	}
	
}
