package com.prep2020.hard;
import java.util.*;
public class Problem689 {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int n = nums.length;
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + nums[i - 1];
		Map<Integer, List<Integer>> oneSum = new HashMap<>();
		List<Integer> list = new ArrayList<>();
		for (int i = n - k; i >= 2 * k ; i--) {
			int curSum = sum[i + k] - sum[i];
			if (list.isEmpty() || list.get(0) <= curSum) {
				list = Arrays.asList(curSum, i);
			}
			oneSum.put(i, new ArrayList<>(list));
		}
		list = new ArrayList<>();
		Map<Integer, List<Integer>> twoSum = new HashMap<>();
		for (int i = n - 2 * k; i >= k; i--) {
			int curSum = sum[i + k] - sum[i] + oneSum.get(i + k).get(0);
			if (list.isEmpty() || list.get(0) <= curSum) {
				list = Arrays.asList(curSum, i, oneSum.get(i + k).get(1));
			}
			twoSum.put(i, new ArrayList<>(list));
		}
		list = new ArrayList<>();
		for (int i = n - 3 * k; i >= 0; i--) {
			int curSum = sum[i + k] - sum[i] + twoSum.get(i + k).get(0);
			if (list.isEmpty() || list.get(0) <= curSum) {
				list = Arrays.asList(curSum, i, twoSum.get(i + k).get(1), twoSum.get(i + k).get(2));
			}
		}
		return new int[] {list.get(1), list.get(2), list.get(3)};
    }
	
	public static void main(String[] args) {
		Problem689 problem = new Problem689();
		int[] arr = problem.maxSumOfThreeSubarrays(new int[] {1,2,1,2,6,7,5,1}, 2);
		for (int i : arr) System.out.print(i + ", ");
	}
}
