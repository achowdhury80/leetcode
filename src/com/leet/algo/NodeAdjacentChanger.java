package com.leet.algo;


//Given a linked list, swap every two adjacent nodes and return its head.
//
//    For example,
//    Given 1->2->3->4, you should return the list as 2->1->4->3.
//
//    Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

/**
 * Created by ayanc on 7/15/17.
 */
public class NodeAdjacentChanger {
  public ListNode swapPairs(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode secondNode = head.next;
    head.next = swapPairs(secondNode.next);
    secondNode.next = head;
    return secondNode;
  }

  public static void main(String[] args){
//    ListNode head = buildList();
//    print(head);
//    head = new NodeAdjacentChanger().swapPairs(head);
    System.out.print(new NodeAdjacentChanger().isPalindrome(1));
//    print(head);
  }

  public static ListNode buildList(){
    ListNode head = new ListNode(1);
    ListNode current = head;
//    current.next = new ListNode(2);
    current = current.next;
//    current.next = new ListNode(3);
//    current = current.next;
//    current.next = new ListNode(4);
//    current = current.next;
//    current.next = new ListNode(5);
    return head;
  }
  public static void print(ListNode head){
    if(head == null) return;
    while(head != null){
      System.out.print("->" + head.val);
      head= head.next;
    }
    System.out.println();
  }

  public boolean isPalindrome(int x) {
    if(x < 0) x *= (-1);
    int reverseInteger = 0;
    System.out.println(x);
    System.out.println(Integer.MAX_VALUE);
    int current = x;
    while(x > 0){
      reverseInteger = reverseInteger * 10 + x % 10;
      current = current / 10;
    }
    System.out.println(reverseInteger);

    return x == reverseInteger;
  }
}


