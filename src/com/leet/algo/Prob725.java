package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob725 {
  public ListNode[] splitListToParts(ListNode root, int k) {
    if(k == 1) return new ListNode[]{root};
    ListNode[] result = new ListNode[k];
    if(root == null) return result;
    int count = 0;
    ListNode node = root;
    count++;
    while (node.next != null){
      node = node.next;
      count++;
    }
    int n = k;
    node = root;
    int i = 0;
    while(count > 0){
      int nextPartCount = 0;
      if(count % n == 0){
        nextPartCount = count / n;
      } else {
        nextPartCount = count / n + 1;
      }
      result[i++] = node;
      n--;
      count -= nextPartCount;
      for(int j = 0; j < nextPartCount - 1; j++){
        node = node.next;
      }
      ListNode temp = node;
      node = node.next;
      temp.next = null;
    }
    return result;
  }
}
