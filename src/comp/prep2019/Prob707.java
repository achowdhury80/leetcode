package comp.prep2019;

public class Prob707 {
	private Node head;
	/** Initialize your data structure here. */
    public Prob707() {
        head = new Node(-1);
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        Node cur = head;
        int j = -1;
        while(cur.next != null) {
        	cur = cur.next;
        	j++;
        	if (j == index) return cur.val;
        }
        return -1;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = head.next;
        head.next = newNode;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
    	Node cur = head;
        while(cur.next != null) cur = cur.next;
        Node newNode = new Node(val);
        cur.next = newNode;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
    	Node cur = head;
        int j = -1;
        while(cur != null) {
        	if (j == index - 1) {
        		Node newNode = new Node(val);
        		newNode.next = cur.next;
        		cur.next = newNode;
        		return;
        	}
        	cur = cur.next;
        	j++;
        }
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
    	Node cur = head;
        int j = -1;
        while(cur.next != null) {
        	if (j == index - 1) {
        		cur.next = cur.next.next;
        		return;
        	}
        	cur = cur.next;
        	j++;
        }
    }
    
    public void print() {
    	Node cur = head;
    	while(cur.next != null) {
    		cur = cur.next;
    		System.out.print(cur.val + ", ");
    	}
    	System.out.println();
    }
    
    class Node {
    	int val; 
    	Node next;
    	Node(int val) {
    		this.val = val;
    	}
    	Node(int val, Node next) {
    		this.val = val;
    		this.next = next;
    	}
    }
    
    
    public static void main(String[] args) {
    	Prob707 prob = new Prob707();
    	prob.addAtHead(7);
		prob.print();
		prob.addAtHead(2);
		prob.print();
		prob.addAtHead(1);
		prob.print();
		prob.addAtIndex(3, 0);
		prob.print();
		prob.deleteAtIndex(2);
		prob.print();
		prob.addAtHead(6);
		prob.print();
		prob.addAtTail(4);
		prob.print();
		System.out.println(prob.get(4));
    }
}
