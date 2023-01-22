package com.prep2020.hard;
import java.util.*;
public class Problem432 {
	private Map<String, Integer> valueMap;
	private Map<Integer, ListNode> valList;
	private ListNode head, tail;
	
	/** Initialize your data structure here. */
    public Problem432() {
    	valueMap = new HashMap<>();
    	valList = new HashMap<>();
    	head = new ListNode(-1);
    	tail = new ListNode(-1);
    	head.next = tail;
    	tail.prev = head;
    }
    
    /** Inserts a new key <Key> with value 1. Or increments an existing key by 1. */
    public void inc(String key) {
    	incr(key, 1);
    }
    
    private void incr(String key, int incrVal) {
    	if (valueMap.containsKey(key)) {
    		int oldVal = valueMap.get(key);
    		int newVal = oldVal + incrVal;
    		if (newVal > 0) valueMap.put(key, newVal);
    		else valueMap.remove(key);
    		ListNode prev = valList.get(oldVal);
    		if (newVal > 0) {
	    		if (valList.containsKey(newVal)) {
	    			valList.get(newVal).keys.add(key);
	    		}
	    		else {
	    			ListNode node = new ListNode(newVal);
	    			node.keys.add(key);
	    			if (oldVal < newVal)
	    				addNodeAfter(node, prev);
	    			else addNodeBefore(node, prev);
	    			valList.put(newVal, node);
	    		}
    		}
			prev.keys.remove(key);
			if (prev.keys.isEmpty()) {
				valList.remove(oldVal);
				deleteNode(prev);
			}
    	} else {
    		valueMap.put(key, 1);
    		if (valList.containsKey(1)) {
    			valList.get(1).keys.add(key);
    		}
    		else {
    			ListNode node = new ListNode(1);
    			node.keys.add(key);
    			addNodeAfter(node, head);
    			valList.put(1, node);
    		}
    	}
    }
    
    /** Decrements an existing key by 1. If Key's value is 1, remove it from the data structure. */
    public void dec(String key) {
        if (!valueMap.containsKey(key)) return;
        incr(key, -1);    
    }
    
    private void addNodeAfter(ListNode newNode, ListNode prevNode) {
    	newNode.next = prevNode.next;
    	prevNode.next.prev = newNode;
    	newNode.prev = prevNode;
    	prevNode.next = newNode;
    }
    
    private void addNodeBefore(ListNode newNode, ListNode nextNode) {
    	newNode.prev = nextNode.prev;
    	nextNode.prev.next = newNode;
    	newNode.next = nextNode;
    	nextNode.prev = newNode;
    }
    
    private void deleteNode(ListNode node) {
    	node.next.prev = node.prev;
    	node.prev.next = node.next;
    }
    
    /** Returns one of the keys with maximal value. */
    public String getMaxKey() {
    	if (tail.prev != head) return tail.prev.keys.iterator().next();
    	return "";
    }
    
    /** Returns one of the keys with Minimal value. */
    public String getMinKey() {
    	if (head.next != tail) return head.next.keys.iterator().next();
    	return "";
    }
    
    static class ListNode {
    	Set<String> keys;
    	int val;
    	ListNode prev, next;
    	ListNode(int val) {
    		keys = new HashSet<>();
    		this.val = val;
    	}
    }
    
    public static void main(String[] args) {
    	Problem432 problem = new Problem432();
    	problem.inc("a");
    	problem.inc("b");
    	problem.inc("b");
    	problem.inc("c");
    	problem.inc("c");
    	problem.inc("c");
    	problem.dec("b");
    	problem.dec("b");
    	System.out.println(problem.getMinKey());
    	problem.dec("a");
    	System.out.println(problem.getMinKey());
    }
}
