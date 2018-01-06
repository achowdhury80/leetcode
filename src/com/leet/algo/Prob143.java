package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob143 {
  public void reorderList(ListNode head) {
    if(head == null || head.next == null || head.next.next == null) return;
    ListNode slow = head;
    ListNode fast = head;
    while(fast.next != null && fast.next.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }
    ListNode right = slow.next;
    slow.next = null;
    Stack<ListNode> stack = new Stack<>();
    while(right != null){
      stack.push(right);
      right = right.next;
    }
    ListNode node = head;
    while (!stack.isEmpty()){
      ListNode temp = stack.pop();
      temp.next = node.next;
      node.next = temp;
      node = temp.next;
    }
  }
}
