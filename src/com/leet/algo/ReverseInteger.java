package com.leet.algo;

/**
 * Created by ayanc on 7/11/17.
 * The input is assumed to be a 32-bit signed integer. Your function should return 0 when the reversed integer overflows.
 */
public class ReverseInteger {
  public static void main(String[] args){
    int result = reverse(-123);
    System.out.println(result);
  }
  public static int reverse(int x) {
      int multiplyFactor = 1;
      if(x < 0) {
        multiplyFactor = -1;
        x = x * (-1);
      }
      int temp = x;
      long result = 0;
      while(temp > 0){
        result = (result * 10 + (temp % 10) * multiplyFactor);
        if(result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
          return 0;
        }
        temp = temp / 10;
      }
      return new Long(result).intValue();
    }

}
