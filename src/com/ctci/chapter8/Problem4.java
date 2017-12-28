package com.ctci.chapter8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 7/23/17.
 */
public class Problem4 {
  public List<List<Integer>> findPowerSet(List<Integer> set){
    if(set == null || set.size() == 0) return null;
    List<List<Integer>> powerSet = new ArrayList<>();
    powerSet.add(new ArrayList<>());
    for(Integer integer : set){
      powerSet = addElement(integer, powerSet);
    }
    return powerSet;
  }

  private List<List<Integer>> addElement(int element, List<List<Integer>> existingPowerSet){
    List<List<Integer>> result = new ArrayList<>();
    result.addAll(existingPowerSet);
    for(List<Integer> set : existingPowerSet){
      List<Integer> integers = new ArrayList<>();
      integers.add(element);
      integers.addAll(set);
      result.add(integers);
    }
    return result;
  }

  public static void main(String[] args){
    Problem4 problem4 = new Problem4();
    List<Integer> set = Arrays.asList(new Integer[]{1,2,3});
    List<List<Integer>> result = problem4.findPowerSet(set);
    System.out.println(result);
  }
}
