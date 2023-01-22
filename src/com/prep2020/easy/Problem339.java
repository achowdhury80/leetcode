package com.prep2020.easy;
import java.util.*;

import com.prep2020.NestedInteger;
public class Problem339 {
	/**
	 * The algorithm takes O(N) time, where NN is the total number of nested elements in 
	 * the input list. For example, the list [ [[[[1]]]], 2 ] contains 44 nested lists 
	 * and 22 nested integers (11 and 22), so N=6N=6.

In terms of space, at most O(D) recursive calls are placed on the stack, where D is the 
maximum level of nesting in the input. For example, D=2D=2 for the input [[1,1],2,[1,1]], 
and D=3D=3 for the input [1,[4,[6]]].
	 * @param nestedList
	 * @return
	 */
	public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
	
	private int helper(List<NestedInteger> nestedList, int depth) {
		int result = 0;
		for (NestedInteger ni : nestedList) {
			if (ni.isInteger()) result += depth * ni.getInteger();
			else result += helper(ni.getList(), depth + 1);
		}
		return result;
	}
}
