package com.prep2020.medium;
import java.util.*;
public class Problem254 {
	public List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		helper(result, 2, n, new ArrayList<>());
		return result;
    }
	
	private void helper(List<List<Integer>> result, int start, int n, 
			List<Integer> temp) {
		if (n == 1) {
			if (temp.size() > 1) result.add(new ArrayList<>(temp));
			return;
		}
		for(int i = start; i <= n; i++) {
			if (n % i != 0) continue;
			temp.add(i);
			helper(result, i, n / i, temp);
			temp.remove(temp.size() - 1);
		}
	}
	
	public static void main(String[] args) {
		Problem254 problem = new Problem254();
		System.out.println(problem.getFactors(12));
	}
}
