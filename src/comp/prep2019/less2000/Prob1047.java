package comp.prep2019.less2000;
import java.util.*;
public class Prob1047 {
	/**
	 * O(N) time and space
	 * @param S
	 * @return
	 */
	public String removeDuplicates(String S) {
		Stack<Character> stack = new Stack<>();
        for (char c : S.toCharArray()) {
        	if (!stack.empty() && stack.peek() == c)stack.pop();
        	else stack.push(c);
        }
        StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty()) sb.insert(0, stack.pop());
        return sb.toString();
    }
}
