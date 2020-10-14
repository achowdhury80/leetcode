package comp.prep2019.less1000;
import java.util.*;
public class Prob150 {
	public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length < 1) return 0;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
        	if (isOperator(token)) {
        		int operand2 = stack.pop(), operand1 = stack.pop();
        		if ("+".equals(token)) stack.push(operand1 + operand2);
        		else if ("-".equals(token)) stack.push(operand1 - operand2);
        		else if ("*".equals(token)) stack.push(operand1 * operand2);
        		else if ("/".equals(token)) stack.push(operand1 / operand2);
        	} else stack.push(Integer.valueOf(token));
        }
        return stack.pop();
    }
	
	private boolean isOperator(String token) {
		return "+-/*".indexOf(token) > -1;
	}
}
