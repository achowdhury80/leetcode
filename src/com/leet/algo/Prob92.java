package com.leet.algo;

/**
 * Created by ayanc on 1/6/18.
 */
public class Prob92 {
  public ListNode reverseBetween(ListNode head, int m, int n) {
    if(head == null || head.next == null || m == n) return head;
    int size = n - m + 1;
    ListNode mNodeParent = head;
    if(m == 1){
      mNodeParent = null;
    }
    else {
      while (mNodeParent != null){
        m--;
        if(m == 1) break;
        mNodeParent = mNodeParent.next;
      }
    }
    ListNode reversedHead = reverse(mNodeParent == null ? head : mNodeParent.next, size);
    if(mNodeParent == null) return reversedHead;
    mNodeParent.next = reversedHead;
    return head;
  }

  private ListNode reverse(ListNode head, int size){
    ListNode last = null;
    ListNode node = head;
    ListNode temp = null;
    for(int i = 0; i < size; i++){
      temp = node.next;
      node.next = last;
      last = node;
      node = temp;
    }
    if(node != null){
      head.next = node;
    }
    return last;
  }
}
