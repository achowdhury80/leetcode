package com.leet.algo;

/**
 * Created by ayanc on 9/14/17.
 */
public class Prob190 {
  public int reverseBits(int n) {
    Long result = 0l;
    for (int i = 0; i < 32; i++){
      result = (result << 1);
      result |= (n & 1);
      n = (n >> 1);
    }
    return result.intValue();
  }

  public static void main(String[] args){
    System.out.println(new Prob190().reverseBits(2));
    System.out.println(new Prob190().reverseBits(43261596));
  }
}
