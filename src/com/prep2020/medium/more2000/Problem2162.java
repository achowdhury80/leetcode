package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2162 {
	public int minCostSetTime(int startAt, int moveCost, int pushCost, int targetSeconds) {
		if (targetSeconds == 0) return pushCost;
        int secondsRemainder = targetSeconds % 60;
        int minutes = targetSeconds / 60;
        int result = Integer.MAX_VALUE;
        if (minutes == 0) {
        	List<Integer> nums = findNums(0, secondsRemainder);
        	int cost = findCost(startAt, moveCost, pushCost, nums);
        	result = Math.min(result, cost);
        } else {
        	if (minutes > 99) {
        		minutes--;
        		secondsRemainder += 60;
        		List<Integer> nums = findNums(minutes, secondsRemainder);
            	int cost = findCost(startAt, moveCost, pushCost, nums);
        		result = Math.min(result, cost);
        	} else {
        		if (secondsRemainder > 39) {
        			List<Integer> nums = findNums(minutes, secondsRemainder);
                	int cost = findCost(startAt, moveCost, pushCost, nums);
            		result = Math.min(result, cost);
        		} else {
        			List<Integer> nums = findNums(minutes, secondsRemainder);
                	int cost = findCost(startAt, moveCost, pushCost, nums);
            		result = Math.min(result, cost);
            		nums = findNums(minutes - 1, secondsRemainder + 60);
                	cost = findCost(startAt, moveCost, pushCost, nums);
            		result = Math.min(result, cost);
        		}
        	}
        }
        return result;
        
    }
	
	private List<Integer> findNums(int min, int sec) {
		List<Integer> result = new ArrayList<>();
		if (min > 0) {
			if (min > 9) result.add(min / 10);
			result.add(min % 10);
		}
		if (sec > 9 || result.size() > 0) {
			result.add(sec / 10);
		}
		result.add(sec % 10);
		return result;
	}
	
	private int findCost(int startAt, int moveCost, int pushCost, List<Integer> num) {
		int result = 0;
		for (int i = 0; i < num.size(); i++) {
			if (startAt != num.get(i)) result += moveCost;
			startAt = num.get(i);
			result += pushCost;
		}
		return result;
	}
}
