package com.leet.algo;

/**
 * Created by ayanc on 3/13/18.
 */
public class Prob2 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1 == null || l2 == null) {
      throw new IllegalArgumentException();
    }
    int carry = 0;
    ListNode dummy = new ListNode(0);
    ListNode cur = dummy;
    while (l1 != null || l2 != null || carry > 0) {
      int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) +  carry;
      ListNode newNode = new ListNode(sum % 10);
      carry = sum / 10;
      cur.next = newNode;
      cur = cur.next;
      l1 = (l1 == null ? null : l1.next);
      l2 = (l2 == null ? null : l2.next);
    }
    return dummy.next;
  }
}
