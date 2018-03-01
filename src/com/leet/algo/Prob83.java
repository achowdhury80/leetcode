package com.leet.algo;

/**
 * Created by ayanc on 2/24/18.
 */
public class Prob83 {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode current = head;
    ListNode next = current.next;
    while (next != null) {
      if (current.val == next.val) {
        current.next = next.next;
      } else current = next;
      next = next.next;
    }
    return head;
  }
}
