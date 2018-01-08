package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob147 {
  public ListNode insertionSortList(ListNode head) {
    if(head == null || head.next == null) return head;
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode node = head.next;
    head.next = null;
    while(node != null){
      ListNode nextNode = node.next;
      ListNode temp = dummy.next;
      if(temp.val > node.val){
        node.next = temp;
        dummy.next = node;
      } else {
        ListNode last = temp;
        while (temp != null && temp.val < node.val){
          last = temp;
          temp = temp.next;
        }
        if(temp == null){
          last.next = node;
          node.next = null;
        } else {
          node.next = last.next;
          last.next = node;
        }
      }
      node = nextNode;
    }
    return dummy.next;
  }

  public static void main(String[] args){
    Prob147 prob147 = new Prob147();
    //int[] arr = new int[]{1, 1};
    int[] arr = new int[]{3, 2, 4};
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;
    for(int i = 0; i < arr.length; i++){
      node.next = new ListNode(arr[i]);
      node = node.next;
    }
    ListNode result = prob147.insertionSortList(dummy.next);
    while(result != null){
      System.out.print(result.val + ",");
      result = result.next;
    }
  }
}
