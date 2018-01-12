package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 1/10/18.
 */
public class Prob633 {

  public boolean judgeSquareSum(int c) {
    Set<Long> set = new HashSet<>();
    long prod = 0l;
    int i = 0;
    while(prod <= c){
      prod = (i + 0l) * (i + 0l);
      if(c == 2 * prod || set.contains(prod)){
        return true;
      }
      i++;
      set.add(c - prod);
    }
    return false;
  }

  public static void main(String[] args){
    Prob633 prob633 = new Prob633();
    System.out.println(prob633.judgeSquareSum(5));
  }
}
