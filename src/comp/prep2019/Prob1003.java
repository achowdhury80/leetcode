package comp.prep2019;
import java.util.*;
public class Prob1003 {
	public boolean isValid(String S) {
        char[] arr = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
        	char c = arr[i];
        	if (c == 'c' && stack.size() >= 2 && stack.peek() == 'b') {
        		stack.pop();
        		if (stack.peek() == 'a') stack.pop();
        		else {
        			stack.push('b');
        			stack.push(c);		
        		}
        	} else {
        		stack.push(c);
        	}
        }
        return stack.isEmpty();
    }
}
