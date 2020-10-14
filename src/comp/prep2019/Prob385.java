package comp.prep2019;
import java.util.*;
import com.leet.algo.NestedInteger;
public class Prob385 {
	public NestedInteger deserialize(String s) {
		Stack<Integer> stack = new Stack<>();
		Map<Integer, Integer> listStartEndMap = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (c == '[') {
				stack.push(i);
			} else if (c == ']') {
				listStartEndMap.put(stack.peek(), i);
				stack.pop();
			}
		}
		return parse(s, 0, s.length() - 1, listStartEndMap);
    }
	
	private NestedInteger parse(String s, int start, int end, 
			Map<Integer, Integer> map) {
		NestedInteger nestedInteger = new NestedInteger();
		if (s.charAt(start) != '[') {
			nestedInteger.setInteger(Integer.parseInt(s.substring(start, end + 1)));
			return nestedInteger;
		}
		StringBuilder sb = new StringBuilder();
		
		for (int i = start + 1; i < end; i++) {
			char c = s.charAt(i);
			if (c == '[') {
				int endIndex = map.get(i);
				nestedInteger.add(parse(s, i, endIndex, map));
				i = endIndex;
			} else {
				if (c == ',') {
					if (!sb.toString().equals("")) {
						nestedInteger.add(
								new NestedInteger(Integer.parseInt(sb.toString())));
						sb = new StringBuilder();
					}
				} else sb.append(c);
			}
		}
		if (!sb.toString().equals("")) {
			nestedInteger.add(
					new NestedInteger(Integer.parseInt(sb.toString())));
		}
		return nestedInteger;
	}
}
