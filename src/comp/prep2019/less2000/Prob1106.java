package comp.prep2019.less2000;
import java.util.*;
public class Prob1106 {
	/**
	 * O(N) time and space
	 * @param expression
	 * @return
	 */
	public boolean parseBoolExpr(String expression) {
		// operator stack
        Stack<Character> operStack = new Stack<>();
        // operand stack
        Stack<Character> operandStack = new Stack<>();
        for (char c : expression.toCharArray()) {
        	if (c == ',') continue;
        	else if (c == ')') {
        		// evaluate expression
        		List<Character> list = new ArrayList<>();
        		while((c = operandStack.pop()) != '(') list.add(c);
        		operandStack.push(evaluate(list, operStack.pop()));
        	} else if (c == '!' || c == '&' || c == '|') {
        		operStack.push(c);
        	} else operandStack.push(c);
        }
        return operandStack.peek() == 't' ? true : false;
    }
	
	/**
	 * evaluate expression
	 * @param list
	 * @param oper
	 * @return
	 */
	private char evaluate(List<Character> list, char oper) {
		if (oper == '!') {
			return list.get(0) == 't' ? 'f' : 't';
		} else if (oper == '&') {
			for (char c : list) {
				if (c == 'f') return 'f';
			}
			return 't';
		} else {
			for (char c : list) {
				if (c == 't') return 't';
			}
			return 'f';
		}
	}
}
