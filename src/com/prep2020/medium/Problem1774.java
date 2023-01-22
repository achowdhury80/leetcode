package com.prep2020.medium;

public class Problem1774 {
	public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
		int[] result = new int[] {Integer.MAX_VALUE};
        for (int b : baseCosts) helper(b, toppingCosts, 0, target, result);
        return result[0];
    }
	
	private void helper(int curCost, int[] toppingCosts, int start, int target, int[] result) {
		if (Math.abs(target - curCost) < Math.abs(result[0] - target) || (Math.abs(target - curCost) == Math.abs(result[0] - target) && curCost < result[0])) result[0] = curCost;
		if (start == toppingCosts.length) return;
		helper(curCost, toppingCosts, start + 1, target, result);
		helper(curCost + toppingCosts[start], toppingCosts, start + 1, target, result);
		helper(curCost + 2 * toppingCosts[start], toppingCosts, start + 1, target, result);
	}
}
