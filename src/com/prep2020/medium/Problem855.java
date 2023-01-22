package com.prep2020.medium;
import java.util.*;
public class Problem855 {
	ListNode head = new ListNode(-1, -1);
	int N;
	public Problem855(int N) {
		this.N = N;
		head.next = new ListNode(-1, N);
    }
    
    public int seat() {
    	ListNode cur = head;
    	ListNode maxParent = head;
    	int maxDist = Integer.MIN_VALUE;
    	while(cur.next != null) {
    		int dist = cur.next.dist;
    		if (dist > maxDist) {
    			maxDist = dist;
    			maxParent = cur;
    		}
    		cur = cur.next;
    	}
        cur = maxParent.next;
        int seat = -1;
        if (cur.x == -1) seat = 0;
        else if (cur.y == N) seat = N - 1;
        else seat = (cur.x + cur.y) / 2;
        ListNode listNode = new ListNode(seat, cur.y);
        cur.setY(seat);
        listNode.next = cur.next;
        cur.next = listNode;
        return seat;
    }
    
    public void leave(int p) {
    	ListNode cur = head;
    	while(cur.next != null) {
    		if (cur.next.y == p) {
    			cur.next.setY(cur.next.next.y);
    			cur.next.next = cur.next.next.next;
    			break;
    		}
    		cur = cur.next;
    	}
    }
    class ListNode {
    	int x, y, dist;
    	ListNode next;
    	public ListNode(int x, int y) {
    		this.x = x;
    		this.y = y;
    		if(x == -1) {
    			this.dist = y;
    		} else if (y == N) {
    			this.dist = N - x - 1;
    		} else this.dist = (y - x) / 2;
    	}
    	
    	void setX(int x) {
    		this.x = x;
    		setDist();
    	}
    	
    	void setY(int y) {
    		this.y = y;
    		setDist();
    	}
    	
    	void setDist() {
    		if(x == -1) {
    			this.dist = y;
    		} else if (y == N) {
    			this.dist = N - x - 1;
    		} else this.dist = (y - x) / 2;
    	}
    }
}
