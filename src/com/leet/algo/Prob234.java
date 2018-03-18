package com.leet.algo;

/**
 * Created by ayanc on 9/18/17.
 */
public class Prob234 {

  public boolean isPalindrome(ListNode head) {
    if(head == null || head.next == null) return true;
    ListNode fast = head;
    ListNode slow = head;
    while (fast.next != null && fast.next.next != null) {
      fast = fast.next.next;
      slow = slow.next;
    }
    ListNode reversed = reverse(slow.next);
    boolean result = true;
    ListNode l1 = head;
    ListNode l2 = reversed;
    while (l2 != null) {
      if (l1.val != l2.val) {
        result = false;
        break;
      }
      l1 = l1.next;
      l2 = l2.next;
    }
    slow.next = reverse(reversed);
    return result;
  }

  private ListNode reverse(ListNode head) {
    if (head == null || head.next == null) return head;
    ListNode cur = head;
    ListNode next = head.next;
    cur.next = null;
    while (next != null) {
      ListNode temp = next;
      next = next.next;
      temp.next = cur;
      cur = temp;
    }
    return cur;
  }

  public boolean isPalindrome1(ListNode head) {
    if(head.next == null) return true;
    int totalCount = 1;
    ListNode start = head;
    while(start.next != null){
      totalCount++;
      start = start.next;
    }
    ListNode tail = start;
    int secondStart = (totalCount + 1) / 2 + 1;
    int count = 1;
    start = head;
    while(count < secondStart - 1){
      count++;
      start = start.next;
    }
    ListNode nodeBeforeSecondStart = start;
    ListNode secondStartNode = start.next;
    ListNode prev = nodeBeforeSecondStart;
    ListNode temp = null;
    do{
      temp = secondStartNode.next;
      secondStartNode.next = prev;
      prev = secondStartNode;
      secondStartNode = temp;
    } while(secondStartNode != null);
    boolean isPalindrom = true;
    start = head;
    ListNode endStart = tail;
    for(int i = 0; i < totalCount / 2; i++){
      if(start.val != endStart.val){
        isPalindrom = false;
        break;
      }
      start = start.next;
      endStart = endStart.next;
      count++;
    }
    prev = null;
    ListNode tailStart = tail;
    do{
      temp = tailStart.next;
      tailStart.next = prev;
      prev = tailStart;
      tailStart = temp;
    } while(tailStart.next != prev);
    return isPalindrom;
  }


  class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
  }

  public static void main(String[] args){
    Prob234 prob234 = new Prob234();
    ListNode head = null;
    System.out.println("true: " + prob234.isPalindrome(head = prob234.createLinkedListFromArray(new int[]{1})));
    prob234.print(head);
    System.out.println("false: " + prob234.isPalindrome(head = prob234.createLinkedListFromArray(new int[]{1,2})));
    prob234.print(head);
    System.out.println("false: " + prob234.isPalindrome(head = prob234.createLinkedListFromArray(new int[]{1,2,3})));
    prob234.print(head);
    System.out.println("true: " + prob234.isPalindrome(head = prob234.createLinkedListFromArray(new int[]{1,2,1})));
    prob234.print(head);
    System.out.println("false: " + prob234.isPalindrome(head = prob234.createLinkedListFromArray(new int[]{1,2,2,3})));
    prob234.print(head);
    System.out.println("true: " + prob234.isPalindrome(head = prob234.createLinkedListFromArray(new int[]{1,2,2,1})));
    prob234.print(head);
    System.out.println("true: " + prob234.isPalindrome(head = prob234.createLinkedListFromArray(new int[]{1,2,3,2,1})));
    prob234.print(head);
    System.out.println("false: " + prob234.isPalindrome(head = prob234.createLinkedListFromArray(new int[]{1,2,3,4,1})));
    prob234.print(head);
  }

  private ListNode createLinkedListFromArray(int[] arr){
    ListNode head = new ListNode(arr[0]);
    ListNode start = head;
    for(int i = 1; i < arr.length; i++){
      start.next = new ListNode(arr[i]);
      start = start.next;
    }
    return head;
  }

  private void print(ListNode head){
    while (head != null){
      System.out.print(head.val + "->");
      head = head.next;
    }
    System.out.println();
  }
}


