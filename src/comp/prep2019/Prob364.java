package comp.prep2019;
import java.util.*;
public class Prob364 {
	public int depthSumInverse(List<NestedInteger> nestedList) {
        int maxDepth = findMaxDepth(nestedList);
        return depthSumInverse(nestedList, maxDepth);
    }
	
	private int depthSumInverse(List<NestedInteger> nestedList, int depth) {
		int result = 0;
		for (NestedInteger nestedInteger : nestedList) {
			if (nestedInteger.isInteger()) {
				result += depth * nestedInteger.getInteger();
			} else result += depthSumInverse(nestedInteger.getList(), depth - 1);
		}
		return result;
	}
	
	private int findMaxDepth(List<NestedInteger> nestedList) {
		int max = 0;
		for (NestedInteger nestedInteger : nestedList) {
			if (!nestedInteger.isInteger()) {
				max = Math.max(max, findMaxDepth(nestedInteger.getList()));
			}
		}
		return 1 + max;
	}
}
