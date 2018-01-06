package com.leet.algo;

/**
 * Created by ayanc on 1/5/18.
 */
public class Prob450 {
  public TreeNode deleteNode(TreeNode root, int key) {
    if(root == null) return root;
    TreeNode parent = null, taregetNode = null;
    TreeNode temp = root;
    TreeNode newRoot = root;
    while (temp != null){
      if(temp.val == key){
        taregetNode = temp;
        break;
      }
      parent = temp;
      if(temp.val > key){
        temp = temp.left;
      } else {
        temp = temp.right;
      }
    }
    if(taregetNode == null) return root;
    if(taregetNode.right == null){
      if(parent != null ){
        if(isLeft(parent, taregetNode)){
          parent.left = taregetNode.left;
        } else {
          parent.right = taregetNode.left;
        }
        return newRoot;
      } else {
        return taregetNode.left;
      }
    }

    if(parent == null){
      newRoot = taregetNode.right;
    } else {
      if(isLeft(parent, taregetNode)){
        parent.left = taregetNode.right;
      } else {
        parent.right = taregetNode.right;
      }
    }

    if(taregetNode.right.left == null){
      taregetNode.right.left = taregetNode.left;
      return newRoot;
    }

    TreeNode smallest = findSmallest(taregetNode.right.left);
    smallest.left = taregetNode.left;
    return newRoot;
  }

  private boolean isLeft(TreeNode parent, TreeNode child){
    if(parent.left == child) return true;
    return false;
  }

  private TreeNode findSmallest(TreeNode treeNode){
    while(treeNode.left != null) treeNode = treeNode.left;
    return treeNode;
  }

  public static void main(String[] args){
    Prob450 prob450 = new Prob450();
    TreeNode t3 = new TreeNode(3);
    t3.left = new TreeNode(2);
    t3.right = new TreeNode(4);
    TreeNode t6 = new TreeNode(6);
    t6.right = new TreeNode(7);
    TreeNode root = new TreeNode(5);
    root.left = t3;
    root.right = t6;
    prob450.deleteNode(root, 3);
  }
}
