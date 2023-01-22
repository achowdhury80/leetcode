package com.prep2020.medium;
import java.util.*;
public class Problem120 {
	/**
	 * O(N^2)
	 * @param triangle
	 * @return
	 */
	public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> last = triangle.get(0);
        for (int i = 1; i < triangle.size(); i++) {
        	List<Integer> temp = new ArrayList<>();
        	for (int j = 0; j < triangle.get(i).size(); j++) {
        		int cur = triangle.get(i).get(j);
        		if (j > 0 && j < triangle.get(i).size() - 1) {
        			cur += Math.min(last.get(j - 1), last.get(j));
        		} else if (j > 0) cur += last.get(j - 1);
        		else cur += last.get(j);
        		temp.add(cur);
        	}
        	last = temp;
        }
        int result = Integer.MAX_VALUE;
        for (int i : last) result = Math.min(result, i);
        return result;
    }
}
