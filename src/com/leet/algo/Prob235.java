package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 9/18/17.
 */
public class Prob235 {
  public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    List<TreeNode> pPath =  new ArrayList<>();
    findPath(root, p, pPath);
    List<TreeNode> qPath =  new ArrayList<>();
    findPath(root, q, qPath);
    TreeNode last = null;
    for(int i = 0; i < pPath.size(); i++){
      if(pPath.get(i) != qPath.get(i)){
        break;
      }
      last = pPath.get(i);
    }
    return last;
  }

  private void findPath(TreeNode root, TreeNode p, List<TreeNode> list){
    list.add(root);
    if(root == p){
      return;
    }
    if(root.val > p.val) findPath(root.left, p, list);
    else findPath(root.right, p, list);
  }
  class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }

  public static void main(String[] args){
    Prob235 prob235 = new Prob235();
    TreeNode treeNode2 = prob235.new TreeNode(2);
    TreeNode treeNode1 = prob235.new TreeNode(1);
    treeNode2.left = treeNode1;
    System.out.println(prob235.lowestCommonAncestor(treeNode2, treeNode2, treeNode1));
  }
}
