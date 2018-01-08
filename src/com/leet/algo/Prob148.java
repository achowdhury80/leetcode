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
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    for(int i = 1; ; i = i * 2){
      ListNode merged = dummy;
      ListNode node = dummy.next;
      int numberOfMerge = 0;
      while(true){
        numberOfMerge++;
        ListNode[] arr = merge(node, i);
        merged.next = arr[0];
        merged = arr[1];
        if(arr[1] == null || arr[1].next == null) break;
        node = arr[1].next;
      }
      if(numberOfMerge < 2) break;
    }
    return dummy.next;
  }

  private ListNode[] merge(ListNode head, int partitionSize){
    ListNode right = head;
    ListNode prevRight = null;
    for(int i = 0; i < partitionSize; i++){
      if(right.next == null) return new ListNode[]{head, null};
      prevRight = right;
      right = right.next;
    }
    if(right == null) return new ListNode[]{head, null};
    //prevRight.next = null;
    int rightPartitionRemains = partitionSize;
    int leftParttionRemains = partitionSize;
    ListNode left = head;
    ListNode dummy = new ListNode(0);
    ListNode node = dummy;
    ListNode last = null;
    while(leftParttionRemains > 0 && rightPartitionRemains > 0 && right != null){
      if(left.val < right.val){
        node.next = left;
        last = left;
        left = left.next;
        leftParttionRemains--;
      } else {
        node.next = right;
        last = right;
        right = right.next;
        rightPartitionRemains--;
      }
      node = node.next;
    }
    if(leftParttionRemains > 0) {
      while (leftParttionRemains > 0) {
        node.next = left;
        last = left;
        left = left.next;
        node = node.next;
        leftParttionRemains--;
      }
      if(rightPartitionRemains == 0){
        last.next = right;
        return new ListNode[]{dummy.next, last};
      } else {
        last.next = null;
        return new ListNode[]{dummy.next, null};
      }
    } else if(rightPartitionRemains > 0){
      if(right == null){
        last.next = null;
        return new ListNode[]{dummy.next, last};
      } else {
        while(rightPartitionRemains > 0){
          node.next = right;
          last = right;
          node = node.next;
          rightPartitionRemains--;
          right = right.next;
          if(right == null) return new ListNode[]{dummy.next, last};
        }
      }
    }
    return new ListNode[]{dummy.next, last};
  }
}
