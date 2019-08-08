package com.leet.algo;

public class Prob707 {
	Node head;
    Node tail;
    int size;
    /** Initialize your data structure here. */
    public Prob707() {
        head = new Node(-1);
        tail = new Node(-1);
        head.next = tail;
        tail.prev = head; 
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
        if(index >= size || index < 0) return -1;
        int idx = 0;
        Node curr = head.next;
        while(idx++ < index && curr!=null)  curr = curr.next;
        if(curr == null) return -1;
        return curr.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        Node node = new Node(val);
        node.next = tail;
        node.prev = tail.prev;
        tail.prev.next = node;
        tail.prev = node;
        size++;
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
        if(index > size) return;
        if(index<0) addAtHead(val);
        int idx = 0;
        Node curr = head.next;
        while(idx++ < index && curr!=null)  curr = curr.next;
        if(curr == null) return;
        Node node = new Node(val);
        curr.prev.next = node;
        node.prev = curr.prev;
        curr.prev = node;
        node.next = curr;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
        if(index >= size || index<0) return;
        int idx = 0;
        Node curr = head.next;
        while(idx++ < index && curr!=null)  curr = curr.next;
        if(curr == null) return;
        curr.prev.next = curr.next;
        curr.next.prev = curr.prev;
        curr.next = curr.prev = null;
        size--;
    }
    class Node{
        int val;
        Node next;
        Node prev;
        public Node(int v){
            val = v;
        }
    }
}
