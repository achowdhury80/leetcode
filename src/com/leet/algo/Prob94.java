package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ayanc on 11/16/17.
 */
public class Prob94 {
  public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<>();
    if(root == null) return list;
    Stack<TreeNodeWithVisit> stack = new Stack<>();
    stack.push(new TreeNodeWithVisit(root));
    while(!stack.isEmpty()){
      TreeNodeWithVisit treeNodeWithVisit = stack.pop();
      if(!treeNodeWithVisit.isVisited()){
        treeNodeWithVisit.setVisited(true);
        TreeNode treeNode = treeNodeWithVisit.getTreeNode();
        if(treeNode.right != null) stack.push(new TreeNodeWithVisit(treeNode.right));
        stack.push(treeNodeWithVisit);
        if(treeNode.left != null) stack.push(new TreeNodeWithVisit(treeNode.left));
      } else {
        list.add(treeNodeWithVisit.getTreeNode().val);
      }
    }
    return list;
  }
  class TreeNodeWithVisit {
    boolean visited;
    TreeNode treeNode;
    public TreeNodeWithVisit(TreeNode treeNode){
      this.treeNode = treeNode;
    }
    public TreeNode getTreeNode(){
      return this.treeNode;
    }

    public boolean isVisited(){
      return visited;
    }

    public void setVisited(boolean visited){
      this.visited = visited;
    }
  }
}
