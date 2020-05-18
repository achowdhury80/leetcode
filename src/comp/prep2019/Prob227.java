package comp.prep2019;
import java.util.*;
import java.util.stream.IntStream;
public class Prob227 {
	public int calculate(String s) {
	    if(s == null || s.trim().length() == 0) return 0;
	    List<String> postfix = findPostFix(s);
	    return evaluatePostfix(postfix);
	  }

	  private List<String> findPostFix(String s){
	    List<String> postFix = new ArrayList<>();
	    Stack<Character> stack = new Stack<>();
	    StringBuilder operand = new StringBuilder();
	    IntStream.range(0, s.length()).forEach(idx ->{
	      char c = s.charAt(idx);
	      if(isOperator(c)){
	        postFix.add(operand.toString().trim());
	        operand.setLength(0);
	        if(isHigher(stack, c)){
	          stack.push(c);
	        } else {
	          while(!isHigher(stack, c)){
	            postFix.add("" + stack.pop());
	          }
	          stack.push(c);
	        }
	      } else {
	        operand.append(c);
	      }
	    });
	    postFix.add(operand.toString().trim());
	    while(!stack.isEmpty()) postFix.add("" + stack.pop());
	    return postFix;
	  }

	  private int evaluatePostfix(List<String> postfix){
	    if(postfix.size() < 1) return 0;
	    Stack<Integer> operands = new Stack<>();
	    for(int i = 0; i < postfix.size(); i++){
	      String element = postfix.get(i);
	      if(element.length() == 1 && isOperator(element.charAt(0))){
	        int second = operands.pop();
	        int first = operands.pop();
	        if(element.charAt(0) == '+'){
	          operands.push(first + second);
	        } else if(element.charAt(0) == '-'){
	          operands.push(first - second);
	        } else if(element.charAt(0) == '*'){
	          operands.push(first * second);
	        } else if(element.charAt(0) == '/'){
	          operands.push(first / second);
	        }
	      } else {
	        operands.push(Integer.valueOf(element));
	      }
	    }
	    return operands.pop();
	  }

	  private boolean isOperator(char c){
	    return c == '+' || c == '-' || c == '*' || c == '/';
	  }

	  private boolean isHigher(Stack<Character> stack, char operator){
	    if(stack.isEmpty()) return true;
	    if(stack.peek() == '/' || stack.peek() == '*') return false;
	    if(operator == '*' || operator == '/') return true;
	    return false;
	  }
}
