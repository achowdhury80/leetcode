package comp.prep2019;
import java.util.*;
public class Prob155 {
	private Stack<Integer> stack = null;
	  private Stack<Integer> minStack = null;

	  /** initialize your data structure here. */
	  public Prob155() {
	    stack = new Stack<>();
	    minStack = new Stack<>();
	  }

	  public void push(int x) {
	    stack.push(x);
	    if (minStack.isEmpty() || minStack.peek() >= x){
	      minStack.push(x);
	    }
	  }

	  public void pop() {
	    int x = stack.pop();
	    if (x == minStack.peek()) minStack.pop();
	  }

	  public int top() {
	    return stack.peek();
	  }

	  public int getMin() {
	    return minStack.peek();
	  }
}
