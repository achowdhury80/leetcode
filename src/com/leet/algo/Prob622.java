package com.leet.algo;

public class Prob622 {
	int[] buffer;
	int front, rear;
	/** Initialize your data structure here. Set the size of the queue to be k. */
    public Prob622(int k) {
        buffer = new int[k + 1];
        front = k;
        rear = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(isFull()) return false;
        rear = (rear + 1) % buffer.length;
        buffer[rear] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % buffer.length;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
       if(isEmpty()) return -1;
       return buffer[(front + 1) % buffer.length];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if(isEmpty()) return -1;
    	return buffer[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear + 1) % buffer.length == front;
    }
    
    public static void main(String[] args) {
    	Prob622 prob = new Prob622(3);
    	System.out.println(prob.enQueue(8));
    	System.out.println(prob.isEmpty());
    	System.out.println(prob.enQueue(0));
    	System.out.println(prob.enQueue(8));
    	System.out.println(prob.enQueue(2));
    	System.out.println(prob.enQueue(4));
    	System.out.println(prob.enQueue(9));
    	System.out.println(prob.Rear());
    	System.out.println(prob.Front());
    	System.out.println(prob.Front());
    	System.out.println(prob.deQueue());
    	
    }
}
