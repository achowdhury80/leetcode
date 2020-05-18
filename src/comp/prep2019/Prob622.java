package comp.prep2019;

public class Prob622 {
	private int[] arr;
	private int front, rear;
	/** Initialize your data structure here. Set the size of the queue to be k. */
    public Prob622(int k) {
        arr = new int[k + 1];
        front = k; 
        rear = k;
    }
    
    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if (isFull()) return false;
        rear = (rear + 1) % arr.length;
        arr[rear] = value;
        return true;
    }
    
    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if (isEmpty()) return false;
        front = (front + 1) % arr.length;
        return true;
    }
    
    /** Get the front item from the queue. */
    public int Front() {
    	if(isEmpty()) return -1;
        return arr[(front + 1) % arr.length];
    }
    
    /** Get the last item from the queue. */
    public int Rear() {
    	if(isEmpty()) return -1;
    	return arr[rear];
    }
    
    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == rear;
    }
    
    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return (rear + 1) % arr.length == front;
    }
}
