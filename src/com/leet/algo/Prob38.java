package com.leet.algo;

/**
 * Created by ayanc on 2/25/18.
 */
public class Prob38 {
  public String countAndSay(int n) {
    if (n == 1) return "1";
    String st = "1";
    for (int i = 2; i <= n; i++) {
      st = nextString(st);
    }
    return st;
  }

  private String nextString(String current) {
    String result = "";
    Character pre = null;
    int count = 0;
    Character cur = null;
    for (int i = 0; i < current.length(); i++) {
      cur = current.charAt(i);
      if (cur == pre) count++;
      else {
        if (count > 0) result += count + "" + pre;
        pre = cur;
        count = 1;
      }
    }
    result += count + "" + pre;
    return result;
  }

  public static void main(String[] args) {
    Prob38 prob38 = new Prob38();
    System.out.println(prob38.countAndSay(4));
  }
}
