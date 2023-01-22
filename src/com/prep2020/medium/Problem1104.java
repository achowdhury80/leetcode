package com.prep2020.medium;
import java.util.*;
public class Problem1104 {
	/**
	 * O(logN)
	 * @param label
	 * @return
	 */
	public List<Integer> pathInZigZagTree(int label) {
		List<Integer> result = new ArrayList<>();
		if (label == 1) {
			result.add(1);
			return result;
		}
		int level = 2;
		while (Math.pow(2, level) - 1 < label) {
			level++;
		}
		int next = label / 2;
		int prevEnd = (int)Math.pow(2, level - 1) - 1, 
				prevStart = (int)Math.pow(2, level - 2);
		int nextLabel = prevStart + (prevEnd - next);
		result.addAll(pathInZigZagTree(nextLabel));
		result.add(label);
		return result;
    }
	
	public static void main(String[] args) {
		Problem1104 problem = new Problem1104();
		System.out.println(problem.pathInZigZagTree(14));
	}
}
