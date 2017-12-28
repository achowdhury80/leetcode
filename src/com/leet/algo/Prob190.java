package com.leet.algo;

/**
 * Created by ayanc on 9/14/17.
 */
public class Prob190 {
  public int reverseBits(int n) {
    Long result = 0l;
    Long factor = 1l;
    for(int i = 0; i < 31; i++) factor *= 2;
    for(int i = 0; i < 32; i++){
      result += (n & 1) * factor;
      n = n >> 1;
      factor = factor / 2;
    }
    return result.intValue();
  }

  public static void main(String[] args){
    System.out.println(new Prob190().reverseBits(2));
  }
}
