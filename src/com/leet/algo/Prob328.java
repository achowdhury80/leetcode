package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob328 {
  public ListNode oddEvenList(ListNode head) {
    if(head == null || head.next == null || head.next.next == null) return head;
    ListNode oddPointer = head;
    ListNode evenPointer = head.next;
    ListNode evenPointerStart = evenPointer;

    while(true){
      if(evenPointer.next == null){
        break;
      }
      oddPointer.next = evenPointer.next;
      oddPointer = oddPointer.next;
      if(evenPointer.next.next == null){
        evenPointer.next = null;
        break;
      }
      evenPointer.next = evenPointer.next.next;
      evenPointer = evenPointer.next;
    }

    oddPointer.next = evenPointerStart;
    return head;
  }
}
