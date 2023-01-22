package com.prep2020.medium;
import java.util.*;
public class Problem1090 {
	/**
	 * O(NLogN) time and O(N) space
	 * @param values
	 * @param labels
	 * @param num_wanted
	 * @param use_limit
	 * @return
	 */
	public int largestValsFromLabels(int[] values, int[] labels, int num_wanted, int use_limit) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < labels.length; i++) list.add(new int[] {labels[i], values[i]});
        Collections.sort(list, (x, y) -> (y[1] - x[1]));
        Map<Integer, Integer> labelUsedMap = new HashMap<>();
        int result = 0;
        int count = 0;
        for (int i = 0; i < list.size() && count < num_wanted; i++) {
        	int sameLabelCount = 0;
        	if ((sameLabelCount = labelUsedMap.getOrDefault(list.get(i)[0], 0)) < use_limit) {
        		count++;
        		labelUsedMap.put(list.get(i)[0], sameLabelCount + 1);
        		result += list.get(i)[1];
        	}
        }
        return result;
    }
}
