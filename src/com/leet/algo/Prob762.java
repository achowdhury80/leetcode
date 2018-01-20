package com.leet.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 1/18/18.
 */
public class Prob762 {
  public int countPrimeSetBits(int L, int R) {
    Set<Integer> primeNumbers = new HashSet<>(Arrays.asList(new Integer[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31}));
    int result = 0;
    while(L <= R){
      if(primeNumbers.contains(Integer.bitCount(L))) result++;
      L++;
    }
    return result;
  }

  public static void main(String[] args){
    Prob762 prob762 = new Prob762();
    System.out.println(prob762.countPrimeSetBits(6, 10));
    System.out.println(prob762.countPrimeSetBits(10, 15));
  }
}
