package comp.prep2019;
import java.util.*;
public class Prob1172 {
	private int capacity, popIndex;
	List<Stack<Integer>> stacks;
	Queue<Integer> pq = new PriorityQueue<>();
	public Prob1172(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
    }
    
    public void push(int val) {
        if (stacks.isEmpty()) {
        	stacks.add(new Stack<>());
        	pq.offer(0);
        	popIndex = 0;
        }
        int pushIndex = -1;
        while(!pq.isEmpty() && (pushIndex = pq.peek()) > popIndex 
        		|| stacks.get(pushIndex).size() == capacity) {
        	pq.poll();
        }
        if (!pq.isEmpty()) {
        	stacks.get(pushIndex).add(val);
        } else {
        	stacks.add(new Stack<>());
        	popIndex = stacks.size() - 1;
        	pq.offer(stacks.size() - 1);
        	stacks.get(stacks.size() - 1).add(val);
        }
    }
    
    public int pop() {
    	int result = -1;
    	adjustPopIndex();
        if (popIndex > -1) {
        	result = stacks.get(popIndex).pop();
        	pq.offer(popIndex);
        }
        adjustPopIndex();
        return result;
    }
    
    private void adjustPopIndex() {
    	while (popIndex > -1 && stacks.get(popIndex).isEmpty()) {
        	stacks.remove(popIndex);
        	popIndex--;
        }
    }
    
    public int popAtStack(int index) {
        if(stacks.isEmpty() || stacks.get(index).isEmpty()) return -1;
        int result = stacks.get(index).pop();
        pq.offer(index);
        return result;
    }
}
