package com.leet.algo;

public class Prob641 {
	private Node head, tail;
	private int count, k;
	
	public Prob641(int k) {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head;
        count = 0;
        this.k = k;
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node node = new Node(value);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        count++;
        return true;
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
    	if (isFull()) return false;
        Node node = new Node(value);
        node.next = tail;
        tail.prev.next = node;
        node.prev = tail.prev;
        tail.prev = node;
        count++;
        return true;
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (isEmpty()) return false;
        Node next = head.next.next;
        next.prev = head;
        head.next = next;
        count--;
        return true;
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
    	if (isEmpty()) return false;
        Node previous = tail.prev.prev;
        previous.next = tail;
        tail.prev = previous;
        count--;
        return true;
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        if (isEmpty()) return -1;
        return head.next.val;
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
    	if (isEmpty()) return -1;
        return tail.prev.val;
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return count == k;
    }
    class Node {
    	int val;
    	Node prev;
    	Node next;
    	Node(int val) {
    		this.val = val;
    	}
    }
}
