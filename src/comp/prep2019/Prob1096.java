package comp.prep2019;
import java.util.*;
public class Prob1096 {
	/**
	 * https://leetcode.com/problems/brace-expansion-ii/discuss/528460/Super-Easy-General-Solution-(Python-but-works-in-any-language)
	 * @param expression
	 * @return
	 */
	public List<String> braceExpansionII(String expression) {
		int r = -1;
		if ((r = expression.indexOf('}')) > -1) {
			String right = expression.substring(r + 1);
			int lastIndex = -1;
			for (int i = r - 1; i > -1; i--) {
				if (expression.charAt(i) == '{') {
					lastIndex = i;
					break;
				}
			}
			String left = expression.substring(0, lastIndex);
			List<String> subList 
				= braceExpansionII(expression.substring(lastIndex + 1, r));
			Set<String> set = new HashSet<>();
			for (String s : subList) {
				String cur = left + s + right;
				set.addAll(braceExpansionII(cur));
			}
			List<String> result = new ArrayList<>(set);
			Collections.sort(result);
			return result;
			
		} else if (expression.indexOf(',') > -1) {
			List<String> result = Arrays.asList(expression.split(","));
			Collections.sort(result);
			return result;
		} else {
			List<String> result = new ArrayList<>();
			result.add(expression);
			return result;
		}
	}
	
	
}
