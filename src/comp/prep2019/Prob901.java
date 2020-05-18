package comp.prep2019;
import java.util.*;
public class Prob901 {
	private Stack<int[]> stack;
	public Prob901() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        if (stack.isEmpty() || stack.peek()[0] > price) {
        	stack.push(new int[] {price, 1});
        	return 1;
        }
        int count = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
        	count += stack.pop()[1];
        }
        stack.push(new int[] {price, count});
        return count;
    }
}
