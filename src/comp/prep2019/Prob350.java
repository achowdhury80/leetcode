package comp.prep2019;
import java.util.*;
public class Prob350 {
	public int[] intersect(int[] nums1, int[] nums2) {
		int n1 = nums1.length, n2 = nums2.length;
		if (n1 == 0 || n2 == 0) return new int[0];
		if (n1 <= n2) return helper(nums1, nums2);
		return helper(nums2, nums1);
    }
	
	private int[] helper(int[] nums1, int[] nums2) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums1) map.put(i, map.getOrDefault(i, 0) + 1);
		for (int i : nums2) {
			if (map.containsKey(i)) {
				list.add(i);
				if (map.get(i) == 1) map.remove(i);
				else map.put(i, map.get(i) - 1);
			}
		}
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
		return result;
	}
}
