package com.leet.algo;

/**
 * Created by ayanc on 1/4/18.
 */
public class Prob230 {
  public int kthSmallest(TreeNode root, int k) {
    return inorder(root, k).val;
  }

  private Info inorder(TreeNode root, int k){
    Info result = new Info();
    if(root.left != null){
      Info leftInfo = inorder(root.left, k);
      if(leftInfo.val != null) return leftInfo;
      result.count = leftInfo.count;
    }
    if(k == result.count + 1){
      result.val = root.val;
      return result;
    }
    result.count = result.count + 1;
    if(root.right != null){
      Info rightInfo = inorder(root.right, k - result.count);
      if(rightInfo.val != null) return rightInfo;
      result.count = result.count + rightInfo.count;
    }
    return result;
  }

  class Info {
    Integer val;
    int count;
  }
}
