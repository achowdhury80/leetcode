package comp.prep2019.less1000;
import java.util.*;

import comp.prep2019.TreeNode;

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
}
