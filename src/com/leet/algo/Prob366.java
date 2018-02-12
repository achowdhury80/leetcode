package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob366 {
  public List<List<Integer>> findLeaves(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    height(root, result);
    return result;
  }

  private int height(TreeNode root, List<List<Integer>> lists) {
    if (root == null) return -1;
    if (root.left == null && root.right == null) {
      if (lists.isEmpty()) lists.add(new ArrayList<>());
      lists.get(0).add(root.val);
      return 0;
    } else {
      int h = Math.max(height(root.left, lists), height(root.right, lists)) + 1;
      if (h == lists.size()) lists.add(new ArrayList<>());
      lists.get(h).add(root.val);
      return h;
    }
  }

  public static void main(String[] args) {
    Prob366 prob366 = new Prob366();
    TreeNode two = new TreeNode(2);
    two.left = new TreeNode(3);
    two.right = new TreeNode(4);
    TreeNode root = new TreeNode(1);
    root.left = two;
    root.right = new TreeNode(5);
    System.out.println(prob366.findLeaves(root));
  }
}

/****
 * Find Leaves of Binary Tree
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves, repeat until the tree is empty.

 Example:
 Given binary tree
 1
 / \
 2   3
 / \
 4   5
 Returns [4, 5, 3], [2], [1].

 Explanation:
 1. Removing the leaves [4, 5, 3] would result in this tree:

 1
 /
 2
 2. Now removing the leaf [2] would result in this tree:

 1
 3. Now removing the leaf [1] would result in the empty tree:

 []
 Returns [4, 5, 3], [2], [1].

 Credits:
 Special thanks to @elmirap for adding this problem and creating all test cases.


 */
