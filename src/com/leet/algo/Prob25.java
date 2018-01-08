package com.leet.algo;

/**
 * Created by ayanc on 1/6/18.
 */
public class Prob25 {
  public ListNode reverseKGroup(ListNode head, int k) {
    if(head == null || head.next == null || k == 1) return head;
    ListNode[] listNodes = null;
    ListNode node = head;
    ListNode dummy = new ListNode(0);
    ListNode node1 = dummy;
    do {
      listNodes = reverse(node, k);
      node1.next = listNodes[0];
      node1 = listNodes[1];
      node = (node1 == null || node1.next == null)? null : node1.next;
    }while (node != null);
    return dummy.next;
  }

  private ListNode[] reverse(ListNode head, int k){
    ListNode node = head;
    for(int i = 0; i < k; i++) {
      if(node == null) return new ListNode[]{head, null};
      node = node.next;
    }
    ListNode last = null;
    node = head;
    ListNode temp = null;
    for(int i = 0; i < k; i++){
      temp = node.next;
      node.next = last;
      last = node;
      node = temp;
    }
    head.next = node;
    return new ListNode[]{last, head};
  }

  public static void main(String[] args){
    Prob25 prob25 = new Prob25();
    int[] arr = new int[]{1, 2, 3};
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;
    for(int i = 0; i < arr.length; i++){
      node.next = new ListNode(arr[i]);
      node = node.next;
    }
    ListNode result = prob25.reverseKGroup(dummy.next, 2);
    while(result != null){
      System.out.print(result.val + ",");
      result = result.next;
    }
  }

}
