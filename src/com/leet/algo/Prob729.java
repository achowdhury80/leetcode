package com.leet.algo;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob729 {
  ListNode root;
  public Prob729() {

  }

  public boolean book(int start, int end) {
    if(root == null){
      root = new ListNode(start, end);
      return true;
    }
    ListNode node = root;
    if(end <= node.start){
      ListNode newNode = new ListNode(start, end);
      newNode.next = root;
      root = newNode;
      return true;
    }
    ListNode last = node;
    while(node != null && node.end <= start){
      last = node;
      node = node.next;
    }
    if(node == null){
      ListNode newNode = new ListNode(start, end);
      last.next = newNode;
      return true;
    } else {
      if(node.start < end) return false;
      ListNode newNode = new ListNode(start, end);
      last.next = newNode;
      newNode.next = node;
      return true;
    }

  }

  class ListNode {
    int start;
    int end;
    ListNode next;

    public ListNode(int start, int end) {
      this.start = start;
      this.end = end;
    }
  }
}
