package comp.prep2019;

import java.util.*;

public class Prob128 {
	public int longestConsecutive1(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);
        int result = 0;
        for (int num : set) {
        	if (!set.contains(num - 1)) {
        		int currentStreak = 1;
        		int cur = num;
        		while(set.contains(cur + 1)) {
        			currentStreak++;
        			cur++;
        		}
        		result = Math.max(result, currentStreak);
        	}
        }
        return result;
    }
}
