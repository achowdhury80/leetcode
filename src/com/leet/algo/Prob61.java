package com.leet.algo;

/**
 * Created by ayanc on 1/6/18.
 */
public class Prob61 {
  public ListNode rotateRight(ListNode head, int k) {
    if(k == 0 || head == null || head.next == null) return head;
    int count = 0;
    ListNode node = head;
    ListNode last = null;
    while (node != null){
      count++;
      last = node;
      node = node.next;
    }
    k = k % count;
    if(k == 0) return head;
    node = head;
    for(int i = 1; i < count - k; i++){
      node = node.next;
    }
    ListNode newStart = node.next;
    node.next = null;
    last.next = head;
    return newStart;
  }

  public static void main(String[] args){
    Prob61 prob61 = new Prob61();
    //int[] arr = new int[]{1, 2, 3, 4, 5};
    int[] arr = new int[]{1, 2};
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;
    for(int i = 0; i < arr.length; i++){
      node.next = new ListNode(arr[i]);
      node = node.next;
    }
    //ListNode result = prob61.rotateRight(dummy.next, 2);
    ListNode result = prob61.rotateRight(dummy.next, 3);
    while(result != null){
      System.out.print(result.val + ",");
      result = result.next;
    }
  }
}
