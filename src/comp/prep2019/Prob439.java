package comp.prep2019;
import java.util.*;
public class Prob439 {
	public String parseTernary(String expression) {
        char[] arr = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        boolean evaluate = false;
        for (int i = arr.length - 1; i > -1; i--) {
        	char c = arr[i];
        	if (c == '?') {
        		evaluate = true;
        	}
        	else if (evaluate) {
        		if (c == 'T') {
        			char ch = stack.pop();
        			stack.pop();
        			stack.push(ch);
        		} else {
        			stack.pop();
        		}
        		evaluate = false;
        	} else if (c != ':') stack.push(c);
        }
        return "" + stack.pop();
    }
}
