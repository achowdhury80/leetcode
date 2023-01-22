package com.prep2020.medium;
import java.util.*;
public class Problem1015 {
	public int smallestRepunitDivByK(int k) {
		if (k % 2 == 0) return -1;
        int result = 0;
        Set<Integer> set = new HashSet<>();
        int cur = 1;
        while(!set.contains(cur)) {
        	set.add(cur);
        	result++;
        	if (cur % k == 0) return result;
        	cur = cur % k;
        	cur = cur * 10 + 1;
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Problem1015 problem = new Problem1015();
		System.out.println(problem.smallestRepunitDivByK(1));
	}
}
