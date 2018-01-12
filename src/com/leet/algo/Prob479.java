package com.leet.algo;

/**
 * Created by ayanc on 9/12/17.
 */
public class Prob479 {
  public int largestPalindrome(int n) {
    if(n == 1) return 9;
    int max = (int)Math.pow(10, n) - 1;
    for(int v = max - 1; v > max / 10; v--){
      long pal = Long.valueOf(v + new StringBuilder().append(v).reverse().toString());
      for(long x = max; x * x >= pal; x--){
        if(pal % x == 0) return (int)(pal % 1337);
      }
    }
    return 0;
  }

  public static void main(String[] args){
    Prob479 prob479 = new Prob479();
    System.out.println(prob479.largestPalindrome(2));
    System.out.println(prob479.largestPalindrome(3));
  }

}
