package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by ayanc on 9/12/17.
 */
public class Prob501 {

  public int[] findMode(TreeNode root) {
    if(root == null) return new int[0];
    Map<Integer, Integer> map = new HashMap<>();
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    while (!stack.isEmpty()){
      TreeNode node = stack.pop();
      map.put(node.val, map.containsKey(node.val) ? map.get(node.val) + 1 : 1);
      if(node.left != null) stack.push(node.left);
      if(node.right != null) stack.push(node.right);
    }
    int max = 0;
    List<Integer> resultList = new ArrayList<>();
    for(Integer key : map.keySet()){
      int value = map.get(key);
      if(value > max){
        resultList.clear();
        resultList.add(key);
        max = value;
      } else if(value == max){
        resultList.add(key);
      }
    }
    return resultList.stream().mapToInt(i -> i).toArray();
  }

  public static void main(String[] args){
    Prob501 prob501 = new Prob501();
    TreeNode root = new TreeNode(1);
    root.right = new TreeNode(2);
    root.right.right = new TreeNode(2);
    Arrays.stream(prob501.findMode(root)).forEach(x -> System.out.print(x + ", "));
  }

}
