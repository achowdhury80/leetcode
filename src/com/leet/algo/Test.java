package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/27/18.
 */
public class Test {
  public ListNode reverseList(ListNode head) {
    if (head == null) return null;
    if (head.next == null) return head;
    ListNode reversed = reverseList(head.next);
    head.next.next = head;
    head.next = null;
    return reversed;
  }
}
