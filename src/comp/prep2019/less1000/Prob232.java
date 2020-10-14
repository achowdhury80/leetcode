package comp.prep2019.less1000;
import java.util.*;

public class Prob232 {
	private Stack<Integer> pushStack, popStack;
	public Prob232() {
		pushStack = new Stack<>();
		popStack = new Stack<>();
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
    	pushStack.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
    	if (!popStack.isEmpty()) return popStack.pop();
    	while(!pushStack.isEmpty()) popStack.push(pushStack.pop());
        return popStack.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (!popStack.isEmpty()) return popStack.peek();
        while(!pushStack.isEmpty()) popStack.push(pushStack.pop());
        return popStack.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return pushStack.isEmpty() && popStack.isEmpty();
    }
}
