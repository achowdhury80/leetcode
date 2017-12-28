package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 12/3/17.
 */
public class Prob508 {
  public int[] findFrequentTreeSum(TreeNode root) {
    if(root == null) return new int[]{};
    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> sums = findSums(root);
    sums.stream().forEach(System.out::println);
    Set<Integer> uniques = new HashSet<>(sums);
    List<Integer> list = new ArrayList<>();
    int currFreq = 0;
    for(Integer i : uniques){
      int freq = Collections.frequency(sums, i);
      if(freq > currFreq){
        list.clear();
        list.add(i);
        currFreq = freq;
      } else if(freq == currFreq){
        list.add(i);
      }
    }
    int[] result = new int[list.size()];
    for(int i = 0; i < list.size(); i++){
      result[i] = list.get(i);
    }
    return result;
  }

  public List<Integer> findSums(TreeNode root){
    List<Integer> results = new ArrayList<>();
    List<Integer> leftSums = null;
    Integer thisSum = root.val;
    if(root.left != null) {
      leftSums = findSums(root.left);
      thisSum += leftSums.get(0);
    }
    List<Integer> rightSums = null;
    if(root.right != null) {
      rightSums = findSums(root.right);
      thisSum += rightSums.get(0);
    }
    results.add(thisSum);
    if(leftSums != null) results.addAll(leftSums);
    if(rightSums != null) results.addAll(rightSums);
    return results;
  }

  public static void main(String[] arhs){
    Prob508 prob508 = new Prob508();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(-3);
    Arrays.stream(prob508.findFrequentTreeSum(root)).forEach(System.out::println);
  }


}
