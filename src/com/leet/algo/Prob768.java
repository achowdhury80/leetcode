package com.leet.algo;

/**
 * Created by ayanc on 1/24/18.
 */
public class Prob768 {
  public int maxChunksToSorted(int[] arr) {
    if(arr == null || arr.length < 1) return 0;
    if(arr.length == 1) return 1;
    ListNode root = new ListNode(arr[0], arr[0]);
    ListNode current = root;
    for(int i = 1; i < arr.length; i++){
      if(arr[i] >= current.max){
        current.next = new ListNode(arr[i], arr[i]);
        current = current.next;
      } else {
        int max = current.max;
        ListNode mover = root;
        ListNode last = root;
        while(mover.max <= arr[i]){
          mover = mover.next;
        }
        mover.next = null;
        mover.max = max;
        mover.min = Math.min(mover.min, arr[i]);
        current = mover;
      }
    }

    current = root;
    int result = 0;
    while(current != null){
      result++;
      current = current.next;
    }
    return result;
  }

  class ListNode {
    int min;
    int max;
    ListNode next;
    ListNode(int min, int max){
      this.min = min;
      this.max = max;
    }
  }

  public static void main(String[] args){
    Prob768 prob768 = new Prob768();
//    System.out.println(prob768.maxChunksToSorted(new int[]{5,4,3,2,1}));
//    System.out.println(prob768.maxChunksToSorted(new int[]{2,1,3,4,4}));
    System.out.println(prob768.maxChunksToSorted(new int[]{0,3,0,3,2}));
  }
}
