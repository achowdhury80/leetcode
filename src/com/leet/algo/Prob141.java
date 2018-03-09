package com.leet.algo;

/**
 * Created by ayanc on 3/5/18.
 */
public class Prob141 {
  public boolean hasCycle(ListNode head) {
    if (head == null) return false;
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null){
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) return true;
    }
    return false;
  }
}
