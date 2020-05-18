package comp.prep2019;
import java.util.*;
public class Prob339 {
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
