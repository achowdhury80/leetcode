package com.prep2020.medium;
import java.util.*;
public class Problem1630 {
	/**
	 * O(NLogN) time and O(N) space
	 * @param nums
	 * @param l
	 * @param r
	 * @return
	 */
	public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
		List<Boolean> result = new ArrayList<>();
		for (int i = 0; i < l.length; i++) result.add(isArithmatic(nums, l[i], r[i]));
		return result;
    }
	
	private boolean isArithmatic(int[] nums, int start, int end) {
		if (end - start < 1) return false;
		if (end - start == 1) return true;
		int[] temp = Arrays.copyOfRange(nums, start, end + 1);
		Arrays.sort(temp);
		int diff = temp[1] - temp[0];
		for (int i = 2; i < temp.length; i++) {
			if (diff != (temp[i] - temp[i - 1])) return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		Problem1630 problem = new Problem1630();
		System.out.println(problem.checkArithmeticSubarrays(new int[] {-12,-9,-3,-12,-6,15,20,-25,-20,-15,-10}, 
				new int[] {8}, new int[] {9}));
	}
}
