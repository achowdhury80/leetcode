package com.prep2020.medium;
import java.util.*;
public class Problem364 {
	public interface NestedInteger {
		      
		 
		      // @return true if this NestedInteger holds a single integer, rather than a nested list.
		      public boolean isInteger();
		 
		      // @return the single integer that this NestedInteger holds, if it holds a single integer
		      // Return null if this NestedInteger holds a nested list
		      public Integer getInteger();
		 
		      // Set this NestedInteger to hold a single integer.
		      public void setInteger(int value);
		 
		      // Set this NestedInteger to hold a nested list and adds a nested integer to it.
		      public void add(NestedInteger ni);
		 
		      // @return the nested list that this NestedInteger holds, if it holds a nested list
		      // Return empty list if this NestedInteger holds a single integer
		      public List<NestedInteger> getList();
		  }
	/**
	 * O(N) time and space
	 * @param nestedList
	 * @return
	 */
	public int depthSumInverse(List<NestedInteger> nestedList) {
		if (nestedList == null) return 0;
		int maxDepth = findMaxDepth(nestedList);
		return depthSum(nestedList, maxDepth);
    }
	
	private int depthSum(List<NestedInteger> nestedList, int depth) {
		int sum = 0;
		for (NestedInteger ne : nestedList) {
			if (ne.isInteger()) sum += depth * ne.getInteger();
			else sum += depthSum(ne.getList(), depth - 1);
		}
		return sum;
	}
	
	private int findMaxDepth(List<NestedInteger> nestedList) {
		if (nestedList == null) return 0;
		int maxDepth = 0;
		for (NestedInteger ne : nestedList) {
			if (!ne.isInteger()) maxDepth = Math.max(maxDepth, findMaxDepth(ne.getList()));
		}
		return 1 + maxDepth;
	}
}
