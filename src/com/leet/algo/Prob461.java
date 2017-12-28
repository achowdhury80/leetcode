package com.leet.algo;

/**
 * Created by ayanc on 9/13/17.
 */
public class Prob461 {
  public int hammingDistance(int x, int y) {
    int result = 0;
    for(int i = 0; i < 32; i++){

      result += (x & 1) == (y & 1) ? 0 : 1;
      x = x >> 1;
      y = y >> 1;
    }
    return result;
  }

  public static void main(String[] args){
    System.out.println(new Prob461().hammingDistance(1, 4));
  }
}
