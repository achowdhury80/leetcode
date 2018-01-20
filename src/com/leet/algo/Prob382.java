package com.leet.algo;

import java.util.Random;

/**
 * Created by ayanc on 1/19/18.
 */
public class Prob382 {
  private ListNode head;
  Random random;
  public Prob382(ListNode head) {
    this.head = head;
    random = new Random();
  }

  /** Returns a random node's value. */
  public int getRandom() {
    ListNode current = head;
    int result = current.val;
    for(int i = 1; current.next != null; i++){
      current = current.next;
      if(random.nextInt(i + 1) == i) result = current.val;
    }
    return result;
  }

  public static void main(String[] args){
    System.out.println(Math.round(Math.random()));
  }
}
