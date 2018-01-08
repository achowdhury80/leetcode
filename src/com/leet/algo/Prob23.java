package com.leet.algo;

/**
 * Created by ayanc on 1/6/18.
 */
public class Prob23 {
  public ListNode mergeKLists(ListNode[] lists) {
    if(lists == null || lists.length < 1) return null;
    if(lists.length < 2) return lists[0];

    return merge(lists, 0, lists.length - 1);
  }

  private ListNode merge(ListNode[] lists, int start, int end){
    if(start >= end) return lists[start];
    int mid = (start + end) / 2;
    ListNode left = merge(lists, start, mid);
    ListNode right = merge(lists, mid + 1, end);
    return mergeLists(left, right);
  }

  private ListNode mergeLists(ListNode head1, ListNode head2){
    if(head1 == null) return head2;
    if(head2 == null) return head1;
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;
    while(head1 != null && head2 != null){
      if(head1.val < head2.val){
        node.next = head1;
        head1 = head1.next;
      } else {
        node.next = head2;
        head2 = head2.next;
      }
      node = node.next;
    }
    if(head1 != null){
      node.next = head1;
    } else {
      node.next = head2;
    }

    return dummy.next;
  }
}
