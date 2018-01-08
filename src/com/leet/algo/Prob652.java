package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 1/7/18.
 */
public class Prob652 {
  public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
    List<TreeNode> list = new ArrayList<>();
    if(root == null || (root.left == null && root.right == null)) return list;
    preOrder(new HashMap<>(), list, root);
    return list;
  }

  private String preOrder(Map<String, Integer> map, List<TreeNode> list, TreeNode root){
    if(root == null) return "#";
    String serial = root.val + "," + preOrder(map, list, root.left) + "," + preOrder(map, list, root.right);
    if(map.getOrDefault(serial, 0) == 1) list.add(root);
    map.put(serial, map.getOrDefault(serial, 0) + 1);
    return serial;
  }


}
