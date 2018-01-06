package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob148 {
  /**
   * merge sort bottom to up
   * start with two elements sort them then 4...so on
   * @param head
   * @return
   */
  public ListNode sortList(ListNode head) {
    if(head == null || head.next == null) return head;
    int i = 1;
    while(true){
      return null;
    }
  }

  private ListNode merge(ListNode head1, int partitionSize){
    ListNode right = head1;
    ListNode prevRight = null;
    for(int i = 0; i < partitionSize; i++){
      if(right.next == null) return null;
      prevRight = right;
      right = right.next;
    }
    int rightPartitionRemains = partitionSize;
    int leftParttionRemains = partitionSize;
    ListNode left = head1;

    if(left.val > right.val){
      ListNode newNode = new ListNode(left.val);
      newNode.next = left.next;
      left = newNode;
      head1.val = right.val;
      head1.next = newNode;
      rightPartitionRemains--;
      right = right.next;
      prevRight.next = right;
      if(right == null) return null;
      if(rightPartitionRemains == 0) return right;
    }
    ListNode prevLeft = head1;
    while (true){
      if(left.val > right.val){
        prevRight.next = right.next;
        right.next = left;
        prevLeft.next = right;
        prevLeft = right;
        int temp = head1.val;

      } else {

      }
    }
  }

  private void swapValues(ListNode node1, ListNode node2){
    int temp = node1.val;
    node1.val = node2.val;

  }
}
