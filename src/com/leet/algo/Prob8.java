package com.leet.algo;

/**
 * Created by ayanc on 2/18/18.
 */
public class Prob8 {
  public int myAtoi(String str) {
    if (str == null || str.length() < 1) return 0;
    char[] arr = str.toCharArray();
    int sign = 1;
    int i = 0;
    while (str.charAt(i) == ' ') i++;
    if (str.charAt(i) == '-' || str.charAt(i) == '+') {
      if (str.charAt(i) == '-') sign = -sign;
      i++;
    }
    char c;
    int base = 0;
    while (i < arr.length && ((c = arr[i++]) <= '9' && c >= '0')) {
      int tail = c - '0';
      if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && tail > 7))
        return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
      base = base * 10 + tail;
    }
    return sign * base ;
  }

  public static void main(String[] args) {
    Prob8 prob8 = new Prob8();
    System.out.println(prob8.myAtoi("1"));
    System.out.println(prob8.myAtoi("    +0a32\""));
    System.out.println(prob8.myAtoi("123"));
  }
}
