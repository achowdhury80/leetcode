package comp.prep2019;
import java.util.*;

public class Prob394 {
	public String decodeString(String s) {
        if (s == null || "".equals(s)) return "";
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
        	if (c != ']') stack.push(c);
        	else {
        		StringBuilder sb = new StringBuilder();
        		char ch;
        		while((ch = stack.pop()) != '[') {
        			sb.insert(0, ch);
        		}
        		int freq = 0;
        		int i = 1;
        		while(!stack.isEmpty() && Character.isDigit(stack.peek())) {
        			freq += i * Integer.valueOf(stack.pop() - '0');
        			i *= 10;
        		}
        		StringBuilder sbb = new StringBuilder();
        		for (int j = 0; j < freq; j++) {
        			sbb.append(sb);
        		}
        		for (char d : sbb.toString().toCharArray()) {
        			stack.push(d);
        		}
        	}
        }
        StringBuilder result = new StringBuilder();
        while(!stack.isEmpty()) result.insert(0, stack.pop());
        return result.toString();
    }
	
	public static void main(String[] args){
	    Prob394 prob394 = new Prob394();
	    System.out.println(prob394.decodeString("3[a]2[bc]"));
	    System.out.println(prob394.decodeString("3[a2[c]]"));
	    System.out.println(prob394.decodeString("2[abc]3[cd]ef"));
	  }
}
