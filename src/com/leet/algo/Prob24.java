package com.leet.algo;

/**
 * Created by ayanc on 3/4/18.
 */
public class Prob24 {
  public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode secondNode = head.next;
    head.next = swapPairs(secondNode.next);
    secondNode.next = head;
    return secondNode;
  }
}
