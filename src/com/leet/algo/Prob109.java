package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob109 {
  public TreeNode sortedListToBST(ListNode head) {
    if(head == null) return null;
    int count = 0;
    ListNode node = head;
    while(node != null){
      count++;
      node = node.next;
    }
    return sortedListToBST(head, count);
  }

  private TreeNode sortedListToBST(ListNode head, int size) {
    if(size == 1) return new TreeNode(head.val);
    int mid = size / 2;
    ListNode midNode = head;
    for(int i = 0; i < mid; i++){
      midNode = midNode.next;
    }
    TreeNode root = new TreeNode(midNode.val);
    root.left = sortedListToBST(head, size / 2);
    int rightSize = size - size / 2 - 1;
    if(rightSize > 0) root.right = sortedListToBST(midNode.next, rightSize);
    return root;
  }
}
