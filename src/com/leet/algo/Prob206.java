package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob206 {
  public ListNode reverseList(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;
    ListNode reversed = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return reversed;
  }
}
