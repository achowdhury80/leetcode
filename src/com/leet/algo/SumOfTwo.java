package com.leet.algo;

/**
 * Created by ayanc on 7/11/17.
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

 You may assume the two numbers do not contain any leading zero, except the number 0 itself.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8
 */

 //Definition for singly-linked list.
 /*class ListNode {
     int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }


public class SumOfTwo {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1 == null || l2 == null) {
      throw new IllegalArgumentException();
    }
    int carry = 0;
    int sum = 0;
    ListNode result = null;
    ListNode temp = null;
    while(l1 != null || l2 != null || carry > 0){
      int l1Val = (l1 == null ? 0 : l1.val);
      int l2Val = (l2 == null ? 0 : l2.val);
      sum = l1Val + l2Val + carry;
      carry = sum / 10;
      sum = sum % 10;
      if(temp == null){
        result = new ListNode(sum);
        temp = result;
      } else {
        temp.next = new ListNode(sum);
        temp = temp.next;
      }
      if(l1 != null) {
        l1 = l1.next;
      }
      if(l2 != null) {
        l2 = l2.next;
      }
    }
    return result;
  }
}*/
