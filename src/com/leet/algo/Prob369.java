package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob369 {
  public ListNode plusOne(ListNode head) {
    Stack<ListNode> stack = new Stack<>();
    ListNode current = head;
    do {
      stack.push(current);
      current = current.next;
    } while (current != null);

    int carry = 1;
    while (carry > 0 && !stack.isEmpty()) {
      current = stack.pop();
      int temp = carry;
      carry = (current.val + carry) / 10;
      current.val = (current.val + temp) % 10;
    }
    if (carry == 1) {
      ListNode node = new ListNode(1);
      node.next = head;
      head = node;
    }
    return head;
  }
}

/**
 * Plus One Linked List
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Given a non-negative integer represented as non-empty a singly linked list of digits, plus one to the integer.

 You may assume the integer do not contain any leading zero, except the number 0 itself.

 The digits are stored such that the most significant digit is at the head of the list.

 Example:
 Input:
 1->2->3

 Output:
 1->2->4
 */
