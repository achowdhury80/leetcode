package com.prep2020.easy;
import java.util.*;
public class Problem350 {
	/**
	 * O(M + N) time
	 * O(M) space
	 * @param nums1
	 * @param nums2
	 * @return
	 */
	public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return intersect(nums2, nums1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) map.put(num, map.getOrDefault(num, 0) + 1);
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
        	if (map.getOrDefault(num, 0) > 0) {
        		list.add(num);
        		map.put(num, map.get(num) - 1);
        	}
        }
        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }
}
