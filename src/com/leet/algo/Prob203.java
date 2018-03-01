package com.leet.algo;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob203 {
  public ListNode removeElements(ListNode head, int val) {
    ListNode result = new ListNode(-1);
    result.next = head;
    ListNode pre = result;
    ListNode cur = head;
    while (cur != null) {
      if (cur.val == val){
        pre.next = cur.next;
      } else pre = cur;
      cur = cur.next;
    }
    return result.next;
  }
}
