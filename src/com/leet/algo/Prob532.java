package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 9/15/17.
 */
public class Prob532 {
  public int findPairs(int[] nums, int k) {
    if(nums == null || nums.length < 2) return 0;
    Set<Pair> set = new HashSet<>();
    for(int i = 0; i < nums.length - 1; i++){
      for(int j = i + 1; j < nums.length; j++)
      if(Math.abs(nums[i] - nums[j]) == k) {
        set.add(new Pair(nums[i], nums[j]));
      }
    }
    return set.size();
  }

  private class Pair {
    int x, y;
    Pair(int x, int y){
      if(x < y) {
        this.x = x;
        this.y = y;
      }else {
        this.y = x;
        this.x = y;
      }
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;

      Pair pair = (Pair) o;

      if (x != pair.x) return false;
      return y == pair.y;

    }

    @Override
    public int hashCode() {
      int result = x;
      result = 31 * result + y;
      return result;
    }
  }

  public static void main(String[] args){
    System.out.println(new Prob532().findPairs(new int[]{3, 1, 4, 1, 5}, 2));
    System.out.println(new Prob532().findPairs(new int[]{1, 2, 3, 4, 5}, 1));
    System.out.println(new Prob532().findPairs(new int[]{1, 3, 1, 5, 4}, 0));
  }
}
