package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob109 {
  public TreeNode sortedListToBST(ListNode head) {
    if(head == null) return null;
    if (head.next == null) return new TreeNode(head.val);
    ListNode fast = head;
    ListNode slow = head;
    ListNode last = null;
    while (fast.next != null && fast.next.next != null){
      fast = fast.next.next;
      last = slow;
      slow = slow.next;
    }
    TreeNode root = new TreeNode(slow.val);
    root.right = sortedListToBST(slow.next);
    if (last != null) {
      last.next = null;
      root.left = sortedListToBST(head);
      last.next = slow;
    }
    return root;
  }

}
