package com.prep2020.easy;
import java.util.*;
public class Problem2200 {
	public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
		List<Integer> result = new ArrayList<>(), keyPos = new ArrayList<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (nums[i] == key) keyPos.add(i);
		}
		if (keyPos.isEmpty()) return result; 
		int index = 0;
		for (int i = 0; i < n; i++) {
			int keyIndex = keyPos.get(index);
			if (keyIndex <= i) {
				if (i - keyIndex <= k) {
					result.add(i);
				} else {
					if (index == keyPos.size() - 1) break;
					index++;
					i--;
					continue;
				}
			} else {
				if (keyIndex - i <= k) result.add(i);
			}
		}
		return result;
    }
}
