package com.leet.algo;

/**
 * Created by ayanc on 3/17/18.
 */
public class Prob160 {
  public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if(headA == headB) return headA;
    if(headA == null || headB == null) return null;
    int listASize = length(headA);
    int listBSize = length(headB);
    int sizeDiff = 0;
    ListNode biggerList = headA;
    ListNode smallerList = headB;
    if(listASize > listBSize){
      sizeDiff = listASize - listBSize;
    } else {
      sizeDiff = listBSize - listASize;
      biggerList = headB;
      smallerList = headA;
    }
    if(sizeDiff > 0){
      for(int i = 0; i < sizeDiff; i++){
        biggerList = biggerList.next;
      }
    }
    while(biggerList != null && smallerList != null){
      if(biggerList == smallerList){
        return biggerList;
      }
      biggerList = biggerList.next;
      smallerList = smallerList.next;
    }
    return null;
  }

  private int length(ListNode head){
    if(head == null) return 0;
    int count = 0;
    while(head != null){
      count++;
      head = head.next;
    }
    return count;
  }
}
