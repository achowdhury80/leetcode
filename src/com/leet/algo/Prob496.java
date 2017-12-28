package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 9/12/17.
 */
public class Prob496 {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    if(nums1 == null || nums1.length == 0) return null;
    int[] result = new int[nums1.length];
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < nums2.length; i++){
      map.put(nums2[i], i);
    }
    for(int i = 0; i < nums1.length; i++){
      Integer pos = map.get(nums1[i] + 1);
      if(pos == null || pos <= i) result[i] = -1;
      else result[i] = pos;
    }
    return result;
  }

  public static void main(String[] args){
    int[] result = new Prob496().nextGreaterElement(new int[]{4,1,2}, new int[]{1,3,4,2});
    for(int i = 0; i < result.length; i++) System.out.print(result[i] + ",");
    System.out.println();
    result = new Prob496().nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4});
    for(int i = 0; i < result.length; i++) System.out.print(result[i] + ",");
    System.out.println();
  }


}
