package com.prep2020.easy;
import java.util.*;
public class Problem2032 {
	/**
	 * O(n1 + n2 + n3)
	 * @param nums1
	 * @param nums2
	 * @param nums3
	 * @return
	 */
	public List<Integer> twoOutOfThree(int[] nums1, int[] nums2, int[] nums3) {
        int[] count = new int[101];
        for (int[] arr : new int[][] {nums1, nums2, nums3}) {
        	boolean[] temp = new boolean[101];
        	for (int i : arr) temp[i] = true;
        	for (int i = 1; i < 101; i++) if (temp[i]) count[i]++;
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
        	if (count[i] > 1) result.add(i);
        }
        return result;
    }
}
