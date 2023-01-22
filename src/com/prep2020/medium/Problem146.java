package com.prep2020.medium;
import java.util.*;
public class Problem146 {
	private ListNode head, end;
	private int capacity;
	private Map<Integer, ListNode> map;
	public Problem146(int capacity) {
        head = new ListNode(-1, -1);
        end = new ListNode(-1, -1);
        head.next = end;
        end.previous = head;
        this.capacity = capacity;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        ListNode node = getNode(key);
        if (node == null) return -1;
        return node.value;
    }
    
    public ListNode getNode(int key) {
        ListNode node = map.get(key);
        if (node == null) return null;
        node.previous.next = node.next;
        node.next.previous = node.previous;
        node.next = head.next;
        node.previous = head;
        head.next = node;
        node.next.previous = node;
        return node;
    }
    
    public void put(int key, int value) {
    	ListNode node = getNode(key);
        if (node != null) node.value = value;
        else {
        	node = new ListNode(key, value);
        	node.next = head.next;
        	node.previous = head;
        	head.next = node;
        	node.next.previous = node;
        	map.put(key, node);
        	if (map.size() > capacity) {
        		map.remove(end.previous.key);
        		end.previous = end.previous.previous;
        		end.previous.next = end;
        	}
        }
    }
    
	class ListNode {
		int key, value;
		ListNode next, previous;

		ListNode(int key, int value) {
			this.key = key;
			this.value = value;
		}
	}
	
	public static void main(String[] args) {
		Problem146 problem = new Problem146(2);
		problem.put(1, 0);
		problem.put(2, 2);
		System.out.println(problem.get(1));
		problem.put(3, 3);
		System.out.println(problem.get(2));
		problem.put(4, 4);
		System.out.println(problem.get(1));
		System.out.println(problem.get(3));
		System.out.println(problem.get(4));
	}
}
