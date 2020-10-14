package comp.prep2019.less2000;
import java.util.*;
public class Prob1172 {
	private int capacity;
	private List<Deque<Integer>> stacks; 
	private int leftMost;
	public Prob1172(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
    }
    
    public void push(int val) {
        if (leftMost == stacks.size()) {
        	Deque<Integer> dq;
        	stacks.add((dq = new ArrayDeque<>(capacity)));
        	dq.addLast(val);
        	return;
        }
        if (stacks.get(leftMost).size() == capacity) {
        	leftMost++;
        	push(val);
        	return;
        }
        stacks.get(leftMost).addLast(val);
    }
    
    public int pop() {
        while(!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
        	stacks.remove(stacks.size() - 1);
        }
        if (stacks.isEmpty()) return -1;
        int idx = stacks.size() - 1;
        int val = stacks.get(idx).removeLast();
        while(!stacks.isEmpty() && stacks.get(stacks.size() - 1).isEmpty()) {
        	stacks.remove(stacks.size() - 1);
        }
        leftMost = Math.max(0, Math.min(leftMost, stacks.size() - 1));
        return val;
    }
    
    public int popAtStack(int index) {
        if (index >= stacks.size()) return -1;
        Deque<Integer> dq = stacks.get(index);
        if (dq.isEmpty()) return -1;
        leftMost = Math.min(leftMost, index);
        return dq.removeLast();
    }
}
