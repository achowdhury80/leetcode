package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 12/22/17.
 */
public class Prob95 {
  public List<TreeNode> generateTrees(int n) {
    List<TreeNode> result = new ArrayList<>();
    if(n < 1) return result;

    if(n == 1) {
      result.add(new TreeNode(n));
      return result;
    }
    List<TreeNode>[][] dp = new List[n + 1][n + 1];
    for(int i = 1; i <= n; i++){
      List<TreeNode> list = new ArrayList<>();
      list.add(new TreeNode(i));
      dp[i][i] = list;
    }
    for(int i = 1; i <= n - 1; i++){
      for(int j = 1; i + j <= n; j++){
        List<TreeNode> list = new ArrayList<>();
        for(int k = j; k <= i + j; k++){
          if(k == j){
            List<TreeNode> rightTreesList = dp[k + 1][i + j];
            for(TreeNode subtree: rightTreesList){
              TreeNode treeNode = new TreeNode(k);
              treeNode.right = subtree;
              list.add(treeNode);
            }
          } else if(k == i + j){
            List<TreeNode> leftTreesList = dp[j][k - 1];
            for(TreeNode subtree: leftTreesList){
              TreeNode treeNode = new TreeNode(k);
              treeNode.left = subtree;
              list.add(treeNode);
            }
          } else {
            List<TreeNode> leftTreesList = dp[j][k - 1];
            List<TreeNode> rightTreesList = dp[k + 1][i + j];
            for(TreeNode subtree1: leftTreesList){
              for(TreeNode subtree2: rightTreesList){
                TreeNode treeNode = new TreeNode(k);
                treeNode.left = subtree1;
                treeNode.right = subtree2;
                list.add(treeNode);
              }
            }
          }
        }
        dp[j][i + j] = list;
      }
    }
    return dp[1][n];
  }


  public static void main(String[] arhs){
    Prob95 prob95 = new Prob95();
    System.out.println(prob95.generateTrees(3).size());
  }
}
