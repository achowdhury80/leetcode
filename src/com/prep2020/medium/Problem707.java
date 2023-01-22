package com.prep2020.medium;

public class Problem707 {
	private int count;
	private ListNode head, tail;
	/** Initialize your data structure here. */
    public Problem707() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if (index >= count) return -1;
        return findNode(index).val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
    	addAfter(head, new ListNode(val));
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	addAfter(tail.prev, new ListNode(val));
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if (index > count) return;
        addAfter(findNode(index - 1), new ListNode(val));
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	if (index >= count) return;
    	delete(findNode(index));
    }
    
    private void addAfter(ListNode node, ListNode newNode) {
    	newNode.next = node.next;
    	newNode.prev = node;
    	node.next = newNode;
    	newNode.next.prev = newNode;
    	count++;
    }
    
    private void delete(ListNode node) {
    	ListNode previous = node.prev;
    	previous.next = node.next;
    	node.next.prev = previous;
    	count--;
    }
    
    private ListNode findNode(int index) {
    	ListNode cur = head;
    	for (int i = 0; i <= index; i++) cur = cur.next;
    	return cur;
    }
    
    class ListNode {
    	int val;
    	ListNode next, prev;
    	ListNode(int val) {
    		this.val = val;
    	}
    }
}
