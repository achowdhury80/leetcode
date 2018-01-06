package com.leet.algo;

import java.util.Stack;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob445 {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if(l1 == null && l2 == null) return new ListNode(0);
    if(l1 == null) return l2;
    if(l2 == null) return l1;
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();
    stack1.push(l1.val);
    while(l1.next != null){
      l1 = l1.next;
      stack1.push(l1.val);
    }
    stack2.push(l2.val);
    while(l2.next != null){
      l2 = l2.next;
      stack2.push(l2.val);
    }
    int carry = 0;
    ListNode result = null;
    while(!stack1.isEmpty() || !stack2.isEmpty()){
      int sum = (stack1.isEmpty() ? 0 : stack1.pop()) + (stack2.isEmpty() ? 0 : stack2.pop()) + carry;
      ListNode node = new ListNode(sum % 10);
      carry = sum / 10;
      node.next = result;
      result = node;
    }
    if(carry > 0){
      ListNode node = new ListNode(carry);
      node.next = result;
      result = node;
    }
    return result;
  }

  public static void main(String[] args){
    Prob445 prob445 = new Prob445();
    int[] input1 = new int[]{7, 2, 4, 3};
    int[] input2 = new int[]{5, 6, 4};
    ListNode x1 = null;
    for(int i = input1.length - 1; i > -1; i--){
      ListNode node = new ListNode(input1[i]);
      node.next = x1;
      x1 = node;
    }
    ListNode x2 = null;
    for(int i = input2.length - 1; i > -1; i--){
      ListNode node = new ListNode(input2[i]);
      node.next = x2;
      x2 = node;
    }

    ListNode result = prob445.addTwoNumbers(x1, x2);
    while(result != null) {
      System.out.print( result.val + ",");
      result = result.next;
    }
  }
}
