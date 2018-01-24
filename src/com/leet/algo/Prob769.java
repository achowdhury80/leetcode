package com.leet.algo;

/**
 * Created by ayanc on 1/23/18.
 */
public class Prob769 {
  private ListNode root;
  public int maxChunksToSorted(int[] arr) {
    root = null;
    if(arr == null || arr.length < 1) return 0;
    if(arr.length < 2) return 1;
    ListNode current = root;
    for(int i = 0; i < arr.length; i++){
      if(current == null){
        root = new ListNode(arr[i], arr[i]);
        current = root;
      } else {
        if(arr[i] >= current.max){
          current.next = new ListNode(arr[i], arr[i]);
          current = current.next;
        } else {
          ListNode node = root;
          while(node.max < arr[i]){
            node = node.next;
          }
          node.next = null;
          node.min = Math.min(node.min, arr[i]);
          node.max = current.max;
          current = node;
        }
      }
    }

    int result = 0;
    current = root;
    while(current != null){
      result++;
      current = current.next;
    }
    return result;
  }

  public static void main(String[] args){
    Prob769 prob769 = new Prob769();
    System.out.println(prob769.maxChunksToSorted(new int[]{4,3,2,1,0}));
    System.out.println(prob769.maxChunksToSorted(new int[]{1,0,2,3,4}));
  }

  class ListNode{
    int min;
    int max;
    ListNode next;

    public ListNode(int min, int max) {
      this.min = min;
      this.max = max;
    }
  }
}
