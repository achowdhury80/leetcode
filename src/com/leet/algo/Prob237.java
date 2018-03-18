package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob237 {
  public void deleteNode(ListNode node) {
    if(node == null || node.next == null) return;
    int val = node.val;
    node.val = node.next.val;
    node.next = node.next.next;
  }
}
