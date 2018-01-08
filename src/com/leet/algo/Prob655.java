package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/4/18.
 */
public class Prob655 {
  public List<List<String>> printTree(TreeNode root) {
    List<List<String>> result = new ArrayList<>();
    if (root == null) return result;
    int treeHight = findHeight(root);
    int noOfColumns = (1 << (treeHight + 1)) - 1;
    for(int i = 0; i <= treeHight; i++){
      List<String> list = new ArrayList<>();
      for(int j = 0; j < noOfColumns; j++){
        list.add("");
      }
      result.add(list);
    }
    populate(result, root, 0, 0, noOfColumns - 1);
    return result;
  }

  private void populate(List<List<String>> result, TreeNode node, int currentLevel, int leftLimit, int rightLimit){
    int currentPos = (leftLimit + rightLimit) / 2;
    result.get(currentLevel).set(currentPos, String.valueOf(node.val));
    if(node.left != null){
      populate(result, node.left, currentLevel + 1, leftLimit, currentPos - 1);
    }
    if(node.right != null){
      populate(result, node.right, currentLevel + 1, currentPos + 1, rightLimit);
    }
  }

  private int findHeight(TreeNode root){
    return root == null ? -1 :
        1 + Math.max(findHeight(root.left), findHeight(root.right));
  }

  public static void main(String[] args){
    Prob655 prob655 = new Prob655();
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    //System.out.println(1 << 1);
    System.out.println(prob655.printTree(root));
  }


}
