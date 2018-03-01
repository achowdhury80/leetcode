package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/24/18.
 */
public class Prob257 {
  public List<String> binaryTreePaths(TreeNode root){
    List<String> result = new ArrayList<>();
    if (root == null) return result;
    helper(root, result, "");
    return result;
  }

  public void helper(TreeNode root, List<String> result, String st){
    st = st + root.val + "->";
    if (root.left == null && root.right == null) {
      st = st.substring(0, st.length() - 2);
      result.add(st);
    } else {
      if (root.left != null) helper(root.left, result, st);
      if (root.right != null) helper(root.right, result, st);
    }
  }
}
