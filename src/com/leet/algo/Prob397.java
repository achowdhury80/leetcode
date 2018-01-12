package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/11/18.
 */
public class Prob397 {
  public int integerReplacement(int n) {
    int result = 0;
    while(n != 1){
      if((n & 1) == 0) n >>>= 1;
      else if( n == 3 || ((n >>>1) & 1) == 0) n--;
      else n++;
      result++;
    }
    return result;
  }

  public static void main(String[] args){
    Prob397 prob397 = new Prob397();
    //System.out.println(prob397.integerReplacement(8));
    //System.out.println(prob397.integerReplacement(7));
    //System.out.println(prob397.integerReplacement(3));
    System.out.println(prob397.integerReplacement(10000));
  }
}
