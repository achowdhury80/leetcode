package comp.prep2019;
import java.util.*;
public class Prob241 {
	public List<Integer> diffWaysToCompute(String input) {
		List<Integer> result = new ArrayList<>();
		int nextOpIdx = findNextOperatorIndex(input, 0);
		if (nextOpIdx == -1) {
			result.add(Integer.parseInt(input));
			return result;
		}
		while(nextOpIdx > - 1) {
			char c = input.charAt(nextOpIdx);
			List<Integer> l1 = diffWaysToCompute(input.substring(0, nextOpIdx));
			List<Integer> l2 = diffWaysToCompute(input.substring(nextOpIdx + 1));
			for (int a : l1) {
				for (int b : l2) {
					if(c == '+') result.add(a + b);
					else if (c == '-') result.add(a - b);
					else result.add(a * b);
				}
			}
			nextOpIdx = findNextOperatorIndex(input, nextOpIdx + 1);
		}
		return result;
    }
	
	private int findNextOperatorIndex(String input, int start) {
		for (int i = start; i < input.length(); i++) {
			char c = input.charAt(i);
			if (c == '+' || c == '-' || c == '*') return i;
		}
		return -1;
	}
}
