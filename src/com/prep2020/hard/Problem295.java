package com.prep2020.hard;
import java.util.*;
/**
 * 
 * @author aychowdh
 *
 */
public class Problem295 {
	/** initialize your data structure here. */
	Queue<Integer> maxQueue, minQueue;
    public Problem295() {
    	maxQueue = new PriorityQueue<>((x, y) -> y - x);
    	minQueue = new PriorityQueue<>();
    }
    /**
     * O(Nlogn) time and O(N) space
     * @param num
     */
    public void addNum(int num) {
    	if (!minQueue.isEmpty() && num > minQueue.peek()) minQueue.offer(num);
    	else maxQueue.offer(num);
    	if (minQueue.size() > maxQueue.size()) maxQueue.offer(minQueue.poll());
    	else if (maxQueue.size() > minQueue.size() + 1) minQueue.offer(maxQueue.poll());
    }

    /**
     * O(1) time
     * @return
     */
    public double findMedian() {
        if (maxQueue.size() > minQueue.size()) return maxQueue.peek();
        return (maxQueue.peek() + minQueue.peek()) / 2.0;
    }
}
