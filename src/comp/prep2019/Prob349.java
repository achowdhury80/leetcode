package comp.prep2019;

import java.util.*;

public class Prob349 {
	public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        for (int i : nums1) set.add(i);
        List<Integer> common = new ArrayList<>();
        for (int i : nums2) {
        	if (set.contains(i)) {
        		common.add(i);
        		set.remove(i);
        	}
        }
        int[] result = new int[common.size()];
        for (int i = 0; i < common.size(); i++) result[i] = common.get(i);
        return result;
    }
}
