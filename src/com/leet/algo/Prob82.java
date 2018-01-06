package com.leet.algo;

/**
 * Created by ayanc on 1/6/18.
 */
public class Prob82 {
  public ListNode deleteDuplicates(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode fakeHead = new ListNode(0);
    fakeHead.next = head;
    ListNode pre = fakeHead;
    ListNode cur = head;
    while (cur != null) {
      while (cur.next != null && cur.next.val == cur.val) {
        cur = cur.next;
      }
      if (pre.next == cur) {
        pre = pre.next;
      } else {
        pre.next = cur.next;
      }
      cur = cur.next;
    }
    return fakeHead.next;
  }
}
