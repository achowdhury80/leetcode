package com.leet.algo;

/**
 * Created by ayanc on 1/26/18.
 */
public class Prob732 {
  private int result = 0;
  private ListNode root = null;
  public Prob732() {

  }

  public int book(int start, int end) {
    if(root == null) {
      root = new ListNode(start, end);
      result = 1;
      return result;
    }
    if(end <= root.start){
      ListNode newNode = new ListNode(start, end);
      newNode.next = root;
      root.parent = newNode;
      root = newNode;
      return result;
    }
    ListNode current = root;
    ListNode last = current;
    while(current.end <= start){
      last = current;
      current = current.next;
    }
    if(current == null){
      ListNode newNode = new ListNode(start, end);
      newNode.parent = last;
      last.next = newNode;
      return result;
    }
    ListNode startNode = current;
    if(start <= current.start){
      ListNode newNode = new ListNode(start, current.start);
      if(current.parent == null){
        newNode.next = current;
        current.parent = newNode;
        root = newNode;
      } else {
        current.parent.next = newNode;
        newNode.parent = current.parent;
        newNode.next = current;
        current.parent = newNode;
      }
      start = current.start;
    }
    return 0;
  }

  class ListNode{
    int start, end, count = 1;
    ListNode next;
    ListNode parent;
    ListNode(int start, int end){
      this.start = start;
      this.end = end;
    }
  }
}
