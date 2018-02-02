package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 1/19/18.
 */
public class Prob421 {
  public int findMaximumXOR(int[] nums) {
    int mask = 0, max = 0;
    for(int i = 31; i >= 0; i--){
      mask |= (1 << i);
      Set<Integer> set = new HashSet<>();
      for(int num : nums) set.add(num & mask);
      int temp = max | (1 << i);
      for (int prefix : set){
        if(set.contains(prefix ^ temp)){
          max = temp;
          break;
        }
      }
    }
    return max;
  }
  public static void main(String[] args){
    Prob421 prob421 = new Prob421();
    System.out.println(prob421.findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
  }


}
