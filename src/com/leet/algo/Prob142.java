package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 1/6/18.
 */
public class Prob142 {
  public ListNode detectCycle(ListNode head) {
    if(head == null || head.next == null) return null;
    if(head.next == head) return head;
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (slow == fast) break;
    }
    if (fast.next == null || fast.next.next == null) return null;
    ListNode result = head;
    while (result != slow){
      result = result.next;
      slow = slow.next;
    }
    return result;
  }
}
