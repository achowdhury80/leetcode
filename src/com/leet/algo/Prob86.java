package com.leet.algo;

/**
 * Created by ayanc on 1/6/18.
 */
public class Prob86 {
  public ListNode partition(ListNode head, int x) {
    if(head == null || head.next == null) return head;
    ListNode leftDummy = new ListNode(0);
    ListNode rightDummy = new ListNode(0);
    ListNode left = leftDummy;
    ListNode right = rightDummy;
    ListNode node = head;
    while(node != null){
      ListNode nextNode = node.next;
      if(node.val < x){
        left.next = node;
        node.next = null;
        left = node;
      } else {
        right.next = node;
        node.next = null;
        right = node;
      }
      node = nextNode;
    }
    if(leftDummy.next == null) return rightDummy.next;
    if(rightDummy.next == null) return leftDummy.next;
    left.next = rightDummy.next;
    return leftDummy.next;
  }
}
