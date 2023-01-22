package com.prep2020.easy;
import java.util.*;
public class Problem2248 {
	public List<Integer> intersection(int[][] nums) {
        int[] arr = new int[1001];
        for (int[] numArr : nums) {
        	for (int i : numArr) arr[i]++;
        }
        int n = nums.length;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < 1001; i++) {
        	if (arr[i] == n) result.add(i);
        }
        return result;
    }
}
