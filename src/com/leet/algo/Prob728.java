package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 12/3/17.
 */
public class Prob728 {
  public List<Integer> selfDividingNumbers(int left, int right) {
    List<Integer> result = new ArrayList<>();
    for(int i = left; i <= right; i++){
      if(isSelfDivisible(i)) result.add(i);
    }
    return result;
  }

  private boolean isSelfDivisible(int n){
    int i = n;
    int j = -1;
    while(i > 0){
      if((j = i % 10) == 0) return false;
      if(n % j != 0) return false;
      i = i / 10;
    }
    return true;
  }

  public static void main(String[] args){
    Prob728 prob728 = new Prob728();
    System.out.println(prob728.selfDividingNumbers(1,10000));
  }
}
