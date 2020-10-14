package comp.prep2019;
import java.util.*;
public class Prob20 {
	/**
	 * O(N)
	 * @param s
	 * @return
	 */
	public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
        	if (c == '(' || c == '{' || c == '[') stack.push(c);
        	else if (c == ')') {
        		if (stack.isEmpty() || stack.peek() != '(') return false;
        		stack.pop();
        	} else if (c == '}') {
        		if (stack.isEmpty() || stack.peek() != '{')  return false;
        		stack.pop();
        	} else if (c == ']') {
        		if (stack.isEmpty() || stack.peek() != '[') return false;
        		stack.pop();
        	}
        }
        return stack.isEmpty();
    }
}
