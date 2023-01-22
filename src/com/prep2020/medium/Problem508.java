package com.prep2020.medium;
import java.util.*;

import com.prep2020.TreeNode;
public class Problem508 {
	/**
	 * O(N) time and space
	 * @param root
	 * @return
	 */
	public int[] findFrequentTreeSum(TreeNode root) {
        int[] maxFreq = new int[1];
        List<Integer> values = new ArrayList<>();
        Map<Integer, Integer> sumFreq = new HashMap<>();
        findSubTreeSum(sumFreq, root, maxFreq, values);
        int[] result = new int[values.size()];
        for (int i = 0; i < values.size(); i++) result[i] = values.get(i);
        return result;
    }
	
	private int findSubTreeSum(Map<Integer, Integer> sumFreq, TreeNode root, 
			int[] maxFreq, List<Integer> values) {
		if (root == null) return 0;
		int leftSum = findSubTreeSum(sumFreq, root.left, maxFreq, values);
		int rightSum = findSubTreeSum(sumFreq, root.right, maxFreq, values);
		int sum = root.val + leftSum + rightSum;
		sumFreq.put(sum, sumFreq.getOrDefault(sum, 0) + 1);
		if (sumFreq.get(sum) > maxFreq[0]) {
			values.clear();
			maxFreq[0] = sumFreq.get(sum);
			values.add(sum);
		} else if (sumFreq.get(sum) == maxFreq[0]) {
			values.add(sum);
		}
		return sum;
	}
}
