package com.leet.algo;

/**
 * Created by ayanc on 9/13/17.
 */
public class Prob191 {
  public int hammingWeight(int n) {
    int result = 0;
    while(n > 0){
      result += n % 2;
      n = n / 2;
    }
    return result;
  }

  public static void main(String[] args){
    Prob191 prob191 = new Prob191();
    System.out.println(prob191.hammingWeight(5));
  }
}
