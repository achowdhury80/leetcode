package comp.prep2019;
import java.util.*;
public class Prob682 {
	public int calPoints(String[] ops) {
		int result = 0;
		Stack<Integer> stack = new Stack<>();
        for (String s : ops) {
        	if (s.equals("+")) {
        		int[] arr = new int[] {stack.pop(), stack.pop()};
        		int temp = arr[0] + arr[1];
        		result += temp;
        		stack.push(arr[1]);
        		stack.push(arr[0]);
        		stack.push(temp);
        	} else if (s.equals("D")) {
        		stack.push(stack.peek() * 2);
        		result += stack.peek();
        	} else if (s.equals("C")) {
        		int temp = stack.pop();
        		result -= temp;
        	} else {
        		int temp = Integer.parseInt(s);
        		result += temp;
        		stack.push(temp);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob682 prob = new Prob682();
		System.out.println(prob.calPoints(new String[] {"5","-2","4","C","D",
				"9","+","+"}));
	}
}
