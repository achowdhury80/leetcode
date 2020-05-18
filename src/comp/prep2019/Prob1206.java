package comp.prep2019;

import java.util.Random;

public class Prob1206 {
	Node head;
	private Random random;
	public Prob1206() {
        head = new Node(-1);
        random = new Random();
    }
    
    public boolean search(int target) {
        Node cur = head.down;
        while(cur != null) {
        	while (cur.right != null && cur.right.val <= target) cur = cur.right;
        	if (cur.val == target) return true;
        	cur = cur.down;
        }
        return false;
    }
    
    public void add(int num) {
    	Node cur = head.down;
    	if (cur == null) {
    		addNewLevel(num);
    		return;
    	}
    	//get to the lowest level
    	while(cur.down != null) {
        	while (cur.right != null && cur.right.val <= num) cur = cur.right;
        	cur = cur.down;
        }
        
    }
    
    private void addNewLevel(int num) {
    	Node cur = new Node(-1);
		cur.right = new Node(num);
		cur.right.left = cur;
		cur.down = head.down;
		head.down = cur;
		cur.up = head;
		return;
    }
    
    private Node promote(Node cur, Node left) {
    	return new Node(-1);
    }
    
    public boolean erase(int num) {
    	Node cur = head.down;
        while(cur != null) {
        	while (cur.right != null && cur.right.val <= num) cur = cur.right;
        	if (cur.val == num) {
        		while(cur.down != null) cur = cur.down;
        		break;
        	}
        	cur = cur.down;
        }
        if (cur == null) return false;
        while(cur != null) {
        	Node left = cur.left;
        	Node right = cur.right;
        	if (left.val == -1 && right == null) {
        		head.down = left.down;
        		return true;
        	}
        	left.right = right;
        	if (right != null) right.left = left;
        	// duplicate case
        	if (right != null && right.val == num) {
        		return true;
        	}
        	cur = cur.up;
        }
        return true;
    }
    
    class Node {
    	int val;
    	Node left, right, up, down;
    	Node(int val) {
    		this.val = val;
    	}
    }
}
