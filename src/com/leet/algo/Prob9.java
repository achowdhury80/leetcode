package com.leet.algo;

/**
 * Created by ayanc on 3/4/18.
 */
public class Prob9 {
  public boolean isPalindrome(int x) {
    if (x < 0) return false;
    int rev = 0;
    int x1 = x;
    while (x1 != 0) {
      int tail = x1 % 10;
      int temp = rev * 10 + tail;
      if ((temp - tail) / 10 != rev) return false;
      rev = temp;
      x1 /= 10;
    }
    return x == rev;
  }

  public static void main(String[] arhs) {
    Prob9 prob9 = new Prob9();
    System.out.println(prob9.isPalindrome(0));
    System.out.println(prob9.isPalindrome(1));
    System.out.println(prob9.isPalindrome(9));
    System.out.println(prob9.isPalindrome(10));
    System.out.println(prob9.isPalindrome(11));
    System.out.println(prob9.isPalindrome(121));
    System.out.println(prob9.isPalindrome(1221));
  }
}
