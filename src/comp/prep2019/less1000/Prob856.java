package comp.prep2019.less1000;
import java.util.*;
public class Prob856 {
	public int scoreOfParentheses(String S) {
        char[] arr = S.toCharArray();
        Stack<Integer> stack = new Stack<>();
        for (char c : arr) {
        	if (c == '(') stack.push(-1);
        	else {
        		int val = 0, temp = 0;
        		while((temp = stack.pop()) != -1) {
        			val += temp;
        		}
        		stack.push(val == 0 ? 1 : 2 * val);
        	}
        }
        int result = 0;
        while(!stack.isEmpty()) result += stack.pop();
        return result;
    }
}
