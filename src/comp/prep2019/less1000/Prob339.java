package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.NestedInteger;
public class Prob339 {
	/**
	 * The algorithm takes O(N)O(N) time, where NN is the total number of nested elements in the input list. For example, the list [ [[[[1]]]], 2 ] contains 44 nested lists and 22 nested integers (11 and 22), so N=6N=6.

In terms of space, at most O(D)O(D) recursive calls are placed on the stack, where DD is the maximum level of nesting in the input. For example, D=2D=2 for the input [[1,1],2,[1,1]], and D=3D=3 for the input [1,[4,[6]]].
	 * @param nestedList
	 * @return
	 */
	public int depthSum(List<NestedInteger> nestedList) {
		int sum = 0;
		for (NestedInteger i : nestedList) {
			sum += helper(i, 1);
		}
		return sum;
    }
	
	private int helper(NestedInteger ne, int depth) {
		if (ne.isInteger()) return depth * ne.getInteger();
		int sum = 0;
		for (NestedInteger i : ne.getList()) {
			sum += helper(i, depth + 1);
		}
		return sum;
	}
}
