package com.leet.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by ayanc on 2/2/18.
 */
public class Prob491 {
  public List<List<Integer>> findSubsequences(int[] nums) {
    TreeMap<Integer, Set<List<Integer>>> treeMap = new TreeMap<>();
    for (int i = nums.length - 1; i > -1; i--) {
      Map<Integer, Set<List<Integer>>> map = treeMap.subMap(nums[i], true, Integer.MAX_VALUE, true);
      if (map.isEmpty()) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[i]);
        treeMap.put(nums[i], new HashSet<>());
        treeMap.get(nums[i]).add(list);
      } else {
        Set<List<Integer>> set = new HashSet<>();
        for (Map.Entry<Integer, Set<List<Integer>>> entry : map.entrySet()) {
          set.addAll(entry.getValue());
          for (List<Integer> list : entry.getValue()) {
            List<Integer> newList = new ArrayList<>(list);
            newList.add(0, nums[i]);
            set.add(newList);
          }
        }
        List<Integer> list = new ArrayList<>();
        list.add(nums[i]);
        set.add(list);
        treeMap.put(nums[i], set);
      }
    }
    Set<List<Integer>> result = new HashSet<>();

    for (Set<List<Integer>> set : treeMap.values()) {
      Set<List<Integer>> newSet = new HashSet<>();
      for (List<Integer> list : set) {
        if (list.size() > 1) newSet.add(list);
      }
      result.addAll(newSet);
    }
    return new ArrayList<>(result);
  }


  public static void main(String[] args) {
    Prob491 prob491 = new Prob491();
    System.out.println(prob491.findSubsequences(new int[]{4, 6, 7, 7}));
  }
}
