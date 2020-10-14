package comp.prep2019.less1000;
import java.util.*;
public class Prob224 {
	public int calculate(String s) {
        int result = 0;
        int sign = 1;
        int val = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == ' ') continue;
        	if (c == '+' || c == '-') {
        		result += sign * val;
        		val = 0;
        		sign = c == '+' ? 1 : -1;
        	}
        	else if (c >= '0' && c <= '9') {
        		val = val * 10 + (c - '0');
        	} else if (c == '(') {
        		stack.push(result);
        		stack.push(sign);
        		result = 0;
        		sign = 1;
        	} else if (c == ')') {
        		result += sign * val;
        		val = 0;
        		sign = 1;
        		result *= stack.pop();
        		result += stack.pop();
        	}
        }
        result += sign * val;
        return result;
    }
	
	public int calculate1(String s) {
        int result = 0;
        int sign = 1;
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c == ' ') continue;
        	if (c == '+' || c == '-') {
        		result += sign * val;
        		val = 0;
        		sign = c == '+' ? 1 : -1;
        	}
        	else if (c >= '0' && c <= '9') {
        		val = val * 10 + (c - '0');
        	} else if (c == '(') {
        		int count = 1;
        		StringBuilder sb = new StringBuilder("");
        		while(count > 0) {
        			i++;
        			c = s.charAt(i);
        			sb.append(c);
        			if (c == '(') count++;
        			else if (c == ')') count--;
        		}
        		sb.deleteCharAt(sb.length() - 1);
        		val = calculate1(sb.toString());
        	}
        }
        result += sign * val;
        return result;
    }
	
	public static void main(String[] args) {
		Prob224 prob = new Prob224();
		System.out.println(prob.calculate("(1+(4+5+2)-3)+(6+8)"));
	}
}
