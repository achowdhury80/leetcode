package com.leet.algo;

/**
 * Created by ayanc on 2/18/18.
 */
public class Prob8 {
  public int myAtoi(String str) {
    if (str == null || str.length() < 1) return 0;
    char[] arr = str.toCharArray();
    int start = -1;
    int i = 0;
    while (i < str.length() && start == -1) {
      char c = str.charAt(i++);
      if (c == ' ' || c == '\t' || c == '\r' || c == '\n') continue;
      start = --i;
    }
    if (start == -1) return 0;
    char sign = '+';
    if (str.charAt(start) == '+' || str.charAt(start) == '-') {
      sign = str.charAt(start);
      start++;
    }
    if (start == str.length() || !Character.isDigit(str.charAt(start))) return 0;
    i = start;
    while (i < str.length()) {
      if (!Character.isDigit(str.charAt(i))) break;
      i++;
    }
    String num = str.substring(start, i);
    if (num.length() > 10) {
      if (sign == '+') return Integer.MAX_VALUE;
      else return Integer.MIN_VALUE;
    }
    long l = Long.parseLong(sign + num);
    if (l < Integer.MIN_VALUE) return Integer.MIN_VALUE;
    if (l > Integer.MAX_VALUE) return Integer.MAX_VALUE;
    return (int)l;
  }

  public static void main(String[] args) {
    Prob8 prob8 = new Prob8();
    System.out.println(prob8.myAtoi("1"));
    System.out.println(prob8.myAtoi("    +0a32\""));
    System.out.println(prob8.myAtoi("123"));
  }
}
