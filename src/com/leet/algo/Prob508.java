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
    if (root == null) return new int[0];
    List<int[]> result = new ArrayList<>();
    findSum(root, new HashMap<>(), result);
    int[] arr = new int[result.size()];
    for (int i = 0; i < result.size(); i++) arr[i] = result.get(i)[0];
    return arr;
  }

  private int findSum(TreeNode root, Map<Integer, Integer> map, List<int[]> list) {
    int sum = root.val;
    if (root.left != null) {
      sum += findSum(root.left, map, list);
    }
    if (root.right != null) sum += findSum(root.right, map, list);
    int freq = map.getOrDefault(sum, 0);
    if (list.isEmpty()) list.add(new int[]{sum, freq + 1});
    else {
      if (list.get(0)[1] == freq + 1) list.add(new int[]{sum, freq + 1});
      else if (list.get(0)[1] < freq + 1) {
        list.clear();
        list.add(new int[]{sum, freq + 1});
      }
    }
    map.put(sum, freq + 1);
    return sum;
  }

  public static void main(String[] arhs){
    Prob508 prob508 = new Prob508();
    TreeNode root = new TreeNode(5);
    root.left = new TreeNode(2);
    root.right = new TreeNode(-3);
    Arrays.stream(prob508.findFrequentTreeSum(root)).forEach(System.out::println);
  }


}
