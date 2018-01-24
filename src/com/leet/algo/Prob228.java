package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/22/18.
 */
public class Prob228 {
  public List<String> summaryRanges(int[] nums) {
    List<String> result = new ArrayList<>();
    if(nums == null || nums.length < 1) return result;
    if(nums.length < 2) {
      result.add(nums[0] + "");
      return result;
    }
    int start = nums[0];
    int last = nums[0];
    int current = nums[0];
    for(int i = 1; i < nums.length; i++){
      current = nums[i];
      if(current != last + 1){
        if(start == last) result.add(last + "");
        else {
          result.add(start + "->" + last);
        }
        start = current;
      }
      last = current;
    }
    if(start == last) result.add(last + "");
    else result.add(start + "->" + last);
    return result;
  }

  public static void main(String[] args){
    Prob228 prob228 = new Prob228();
    System.out.println(prob228.summaryRanges(new int[]{0,1,2,4,5,7}));
    System.out.println(prob228.summaryRanges(new int[]{0,2,3,4,6,8,9}));
  }
}
