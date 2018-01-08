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
    Set<ListNode> set = new HashSet<>();
    ListNode node = head;
    while(node != null){
      if(set.contains(node.next)) return node.next;
      set.add(node);
      node = node.next;
    }
    return null;
  }
}
