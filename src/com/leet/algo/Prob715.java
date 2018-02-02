package com.leet.algo;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by ayanc on 1/30/18.
 */
public class Prob715 {
  TreeMap<Integer, Integer> treeMap;
  public Prob715() {
    treeMap = new TreeMap<>();
  }

  public void addRange(int left, int right) {
    if(left > right) return;
    if(treeMap.isEmpty()){
      treeMap.put(left, right);
      return;
    }
    Integer lowerToRight = treeMap.lowerKey(right);
    if(treeMap.containsKey(left)){
      int existingRight = treeMap.get(left);
      if(existingRight >= right) return;
      Integer keyContainingRight = findKey(right);
      if(keyContainingRight != null){
        merge(left, keyContainingRight);
        return;
      } else {
        if(lowerToRight != left){
          treeMap.put(lowerToRight, right);
          merge(left, lowerToRight);
          return;
        } else {
          treeMap.put(left, right);
        }
      }
    }
    Integer keyContainingRight = findKey(right);
    Integer keyContainingLeft = findKey(left);
    if (keyContainingLeft != null && keyContainingLeft == keyContainingRight) return;
    if (keyContainingLeft != null && keyContainingRight != null){
      merge(keyContainingLeft, keyContainingRight);
      return;
    }
    else if (keyContainingLeft == null && keyContainingRight == null){
      Integer nextFromLeft = treeMap.higherKey(left);
      Integer beforeRight = treeMap.lowerKey(right);
      //right most or leftMost
      if (nextFromLeft == null || beforeRight == null || nextFromLeft > beforeRight){
        treeMap.put(left, right);
        return;
      }
      merge(nextFromLeft, beforeRight);
      treeMap.put(left, right);
      treeMap.remove(nextFromLeft);
      return;
    } else if (keyContainingLeft == null){
      Integer nextFromLeft = treeMap.higherKey(left);
      merge(nextFromLeft, keyContainingRight);
      treeMap.put(left, treeMap.get(nextFromLeft));
      treeMap.remove(nextFromLeft);
    } else {
      Integer beforeRight = treeMap.lowerKey(right);
      merge(keyContainingLeft, beforeRight);
      treeMap.put(keyContainingLeft, right);
    }
  }

  private Integer findKey(int val){
    if(treeMap.containsKey(val)) return val;
    Integer lower = treeMap.lowerKey(val);
    if(lower == null || treeMap.get(lower) < val) return null;
    return lower;
  }

  private void merge(int left, int right){
    int rightMost = treeMap.get(right);
    Map<Integer, Integer> map = treeMap.subMap(left, true, right, true);
    Set<Integer> set = new HashSet<>();
    for(Integer key : map.keySet()) set.add(key);
    for(Integer key : set) treeMap.remove(key);
    treeMap.put(left, rightMost);
  }

  public boolean queryRange(int left, int right) {
    if(left > right) return false;
    Integer leftContainingKey = findKey(left);
    if(leftContainingKey == null) return false;
    return leftContainingKey == findKey(right);
  }

  public void removeRange(int left, int right) {
    if(left > right) return;
    Integer keyContainingRight = findKey(right);
    Integer keyContainingLeft = findKey(left);
    Integer nextFromLeft = treeMap.higherKey(left);
    Integer beforeRight = treeMap.lowerKey(right);
    if(keyContainingLeft == null && keyContainingRight == null){
      if(nextFromLeft == null || beforeRight == null || nextFromLeft > beforeRight) return;
      merge(nextFromLeft, beforeRight);
      treeMap.remove(nextFromLeft);
    }
    else if(keyContainingLeft == null){
      if(nextFromLeft == null) return;
      if(treeMap.get(keyContainingRight) > right){
        treeMap.put(right, treeMap.get(keyContainingRight));
      }
      merge(nextFromLeft, keyContainingRight);
      treeMap.remove(nextFromLeft);
    }
    else if(keyContainingRight == null){
      if(beforeRight == null) return;
      merge(keyContainingLeft, beforeRight);
      treeMap.remove(keyContainingLeft);
      if(keyContainingLeft < left){
        treeMap.put(keyContainingLeft, left);
      }
    } else {
      if(treeMap.get(keyContainingRight) > right){
        treeMap.put(right, treeMap.get(keyContainingRight));
      }
      merge(keyContainingLeft, keyContainingRight);
      treeMap.remove(keyContainingLeft);
      if(keyContainingLeft < left){
        treeMap.put(keyContainingLeft, left);
      }
    }
  }

  public static void main(String[] args){
    Prob715 prob715 = new Prob715();
    prob715.addRange(10, 20);
    prob715.removeRange(14, 16);
    System.out.println(prob715.queryRange(10, 14));
    System.out.println(prob715.queryRange(13, 15));
    System.out.println(prob715.queryRange(16, 17));



//    prob715.addRange(10, 180);
//    prob715.addRange(150, 200);
//    prob715.addRange(250, 500);
//    System.out.println(prob715.queryRange(50, 100));
//    System.out.println(prob715.queryRange(180, 300));
  }




}
