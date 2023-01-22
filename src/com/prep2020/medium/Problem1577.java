package com.prep2020.medium;
import java.util.*;
public class Problem1577 {
	public int numTriplets(int[] nums1, int[] nums2) {
        long result = 0;
        Map<Long, Long> map2 = findFreqMap(nums2);
        for (int i : nums1) {
        	result += findCount((1l * i) * i, map2);
        }
        Map<Long, Long> map1 = findFreqMap(nums1);
        for (int i : nums2) {
        	result += findCount((1l * i) * i, map1);
        }
        return (int)result;
    }
	
	private long findCount(long num, Map<Long, Long> freqMap) {
		long result = 0;
		for (long i = 1; i * i <= num; i++) {
			if (num % i != 0) continue;
			if (i * i == num) {
				long count = freqMap.getOrDefault(i, 0l);
				if (count > 1) result += (count * (count - 1)) / 2;
			} else {
				result += freqMap.getOrDefault(i, 0l) * freqMap.getOrDefault(num / i, 0l);
			}
		}
		return result;
	}
	
	private Map<Long, Long> findFreqMap(int[] nums) {
		Map<Long, Long> map = new HashMap<>();
		for (int n : nums) {
			map.put((long)n, map.getOrDefault((long)n, 0l) + 1);
		}
		return map;
	}
	
	public static void main(String[] args) {
		Problem1577 problem = new Problem1577();
		System.out.println(problem.numTriplets(new int[] {7, 4}, new int[] {5, 2, 8, 9}));
	}
}
