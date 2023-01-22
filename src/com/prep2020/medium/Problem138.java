package com.prep2020.medium;
import java.util.*;
public class Problem138 {
	public Node copyRandomList(Node head) {
        if (head == null) return head;
        Node dummy = new Node(-1), dummyNew = new Node(-1);
        dummy.next = head;
        Node cur = dummy, curNew = dummyNew;
        Map<Node, Node> map = new HashMap<>();
        while(cur.next != null) {
        	curNew.next = new Node(cur.next.val);
        	map.put(cur.next, curNew.next);
        	cur = cur.next;
        	curNew = curNew.next;
        }
        cur = head;
        map.put(null, null);
        while(cur != null) {
        	Node clone = map.get(cur);
        	clone.random = map.get(cur.random);
        	cur = cur.next;
        }
        
        return dummyNew.next;
    }
	
	class Node {
	    int val;
	    Node next;
	    Node random;

	    public Node(int val) {
	        this.val = val;
	        this.next = null;
	        this.random = null;
	    }
	}
}
