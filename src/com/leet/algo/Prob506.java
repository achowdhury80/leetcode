package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 9/15/17.
 */
public class Prob506 {
  public String[] findRelativeRanks(int[] nums) {
    if(nums == null || nums.length < 1) return null;
    ValIndex[] valIndices = new ValIndex[nums.length];
    for(int i = 0; i < nums.length; i++){
      valIndices[i] = new ValIndex(nums[i], i);
    }
    Arrays.sort(valIndices);
    String[] result = new String[nums.length];
    result[valIndices[nums.length - 1].index] = "Gold Medal";
    if(nums.length > 1){
      result[valIndices[nums.length - 2].index] = "Silver Medal";
    }
    if(nums.length > 2){
      result[valIndices[nums.length - 3].index] = "Bronze Medal";
    }
    int rank = 4;
    if(nums.length > 3) {
      for (int i = nums.length - 4; i > -1; i--) {
        result[valIndices[i].index] = String.valueOf(rank);
        rank++;
      }
    }
    return result;
  }

  class ValIndex implements Comparable<ValIndex>{
    private int value;
    private int index;

    public ValIndex(int value, int index) {
      this.value = value;
      this.index = index;
    }

    @Override
    public int compareTo(ValIndex o) {
      if(this.value > o.value) return 1;
      if(this.value == o.value) return 0;
      return -1;
    }


  }

  public static void main(String[] args){
    String[] result = new Prob506().findRelativeRanks(new int[]{5, 4, 3, 2, 1});
    for(int i = 0; i < result.length; i++){
      System.out.println(result[i]);
    }
  }
}
