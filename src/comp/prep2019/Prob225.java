package comp.prep2019;

import java.util.ArrayList;
import java.util.List;

public class Prob225 {
	private List<Integer> queue1 = new ArrayList<Integer>();
	  private List<Integer> queue2 = new ArrayList<Integer>();

	  /** Initialize your data structure here. */
	  public Prob225() {

	  }

	  /** Push element x onto stack. */
	  public void push(int x) {
	    if(queue1.size() < 1){
	      queue2.add(x);
	    } else {
	      queue1.add(x);
	    }
	  }

	  /** Removes the element on top of the stack and returns that element. */
	  public int pop() {
	    List<Integer> emptyQueue = null;
	    List<Integer> nonEmptyQueue = null;
	    if(queue1.size() < 1){
	      emptyQueue = queue1;
	      nonEmptyQueue = queue2;
	    } else {
	      emptyQueue = queue2;
	      nonEmptyQueue = queue1;
	    }
	    while(nonEmptyQueue.size() > 1){
	      emptyQueue.add(nonEmptyQueue.remove(0));
	    }
	    return nonEmptyQueue.remove(0);
	  }

	  /** Get the top element. */
	  public int top() {
	    List<Integer> emptyQueue = null;
	    List<Integer> nonEmptyQueue = null;
	    if(queue1.size() < 1){
	      emptyQueue = queue1;
	      nonEmptyQueue = queue2;
	    } else {
	      emptyQueue = queue2;
	      nonEmptyQueue = queue1;
	    }
	    while(nonEmptyQueue.size() > 1){
	      emptyQueue.add(nonEmptyQueue.remove(0));
	    }
	    int temp = nonEmptyQueue.remove(0);
	    emptyQueue.add(temp);
	    return temp;
	  }

	  /** Returns whether the stack is empty. */
	  public boolean empty() {
	    return queue1.size() < 1 && queue2.size() < 1;
	  }
}
