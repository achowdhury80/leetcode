package com.prep2020.easy;

import com.prep2020.TreeNode;
import java.util.*;

public class Problem501 {
	/**
	 * 0(N) time and O(H) space
	 * go for in-order
	 * @return
	 */
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
}
