package comp.prep2019.less1000;
import java.util.*;
public class Prob295 {
	/** initialize your data structure here. */
	private Queue<Integer> minQ, maxQ;
    public Prob295() {
    	minQ = new PriorityQueue<>();
    	maxQ = new PriorityQueue<>((x, y) -> y - x);
    }
    
    public void addNum(int num) {
    	if (!minQ.isEmpty() && num > minQ.peek()) {
    		minQ.offer(num);
    		if (minQ.size() > maxQ.size()) maxQ.offer(minQ.poll());
    	} else {
    		maxQ.offer(num);
    		if (maxQ.size() > minQ.size() + 1) minQ.offer(maxQ.poll());
    	}
    }
    
    public double findMedian() {
        if (minQ.size() == maxQ.size()) return (maxQ.peek() + 0.0 + minQ.peek()) / 2;
        return maxQ.peek();
    }
    
    public static void main(String[] args) {
    	Prob295 prob = new Prob295();
    	prob.addNum(1);
    	prob.addNum(2);
    	System.out.println(prob.findMedian());
    	prob.addNum(3);
    	System.out.println(prob.findMedian());
    }
}
