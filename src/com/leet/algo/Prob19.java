package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob19 {
  public ListNode removeNthFromEnd(ListNode head, int n) {
    if(head == null) return head;
    int count = 1;
    ListNode node = head;
    while(node != null && count < n - 1){
      node = node.next;
      count++;
    }
    if(node.next == null) {
      if(n != 1) return head;
      else return null;
    }
    node = node.next;
    ListNode parent = null;
    if(n == 1) parent = head;
    if(node.next == null) {
      if(n == 1){
        head.next = null;
        return head;
      }
      else return head.next;
    }
    node = node.next;
    if(parent == null) parent = head;
    else parent = parent.next;
    while (node.next != null){
      node = node.next;
      parent = parent.next;
    }
    ListNode temp = parent.next;
    parent.next = temp.next;
    temp.next = null;
    return head;
  }

  public static void main(String[] args){
    Prob19 prob19 = new Prob19();
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    ListNode result = prob19.removeNthFromEnd(head, 1);
    while(result != null) {
      System.out.print(result.val + ",");
      result = result.next;
    }

  }
}
