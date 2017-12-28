package com.leet.algo;

/**
 * Created by ayanc on 12/11/17.
 */
public class Prob357 {
  public int countNumbersWithUniqueDigits(int n) {
    if(n == 0) return 1;
    int[] count = new int[n + 1];
    count[0] = 1;
    for(int i = 1; i <= n; i++){
      int temp = 9;
      int num = 9;
      for(int j = i - 1; j > 0; j--){
        temp *= num;
        num--;
      }
      count[i] = temp + count[i - 1];
    }
    return count[n];
  }

  public static void main(String[] args){
    Prob357 prob357 = new Prob357();
    System.out.println(prob357.countNumbersWithUniqueDigits(0));
    System.out.println(prob357.countNumbersWithUniqueDigits(100));
  }
}
