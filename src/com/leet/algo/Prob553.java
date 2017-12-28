package com.leet.algo;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ayanc on 12/6/17.
 */
public class Prob553 {
  public String optimalDivision(int[] nums) {

    if(nums == null || nums.length == 0) return null;
    if(nums.length == 1) return "" + nums[0];
    if(nums.length == 2) return nums[0] + "/" + nums[1];
    StringBuilder ans = new StringBuilder("" + nums[0] + "/(");
    for(int i = 1; i < nums.length; i++){
      ans.append(nums[i] + "/");
    }
    ans.delete(ans.length() - 1, ans.length());
    ans.append(")");
    return ans.toString();
  }

  public static void main(String[] args){
    Prob553 prob553 = new Prob553();
    System.out.println(prob553.optimalDivision(new int[] {1000, 100, 10, 2}));
    System.out.println(prob553.optimalDivision(new int[] {6, 2, 3, 4, 5}));
  }
}
