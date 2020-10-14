package comp.prep2019.less2000;
import java.util.*;

public class Prob1458 {
	public int maxDotProduct(int[] nums1, int[] nums2) {
        return helper(nums1, nums2, 0, 0, new HashMap<>());
    }
	
	private int helper(int[] nums1, int[] nums2, int s1, int s2, 
			Map<Integer, Integer> cache) {
		int key = (s1 << 9) | s2;
		if(cache.containsKey(key)) return cache.get(key);
		int result = 0;
		int prod = result = nums1[s1] * nums2[s2];
		if (s1 == nums1.length - 1 && s2 == nums2.length - 1) {
			cache.put(key, result);
			return result;
		}
		if (s2 < nums2.length - 1) {
			result = Math.max(result, helper(nums1, nums2, s1, s2 + 1, cache));
		}
		
		if (s1 < nums1.length - 1) {
			result = Math.max(result, helper(nums1, nums2, s1 + 1, s2, cache));
		}
		
		if(s1 < nums1.length - 1 && s2 < nums2.length - 1) {
			result = Math.max(result, prod + helper(nums1, nums2, s1 + 1, s2 + 1, 
					cache));
		}
		
		cache.put(key, result);
		return result;
	}
}
