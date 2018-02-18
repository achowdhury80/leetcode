package com.leet.algo;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob161 {
  public boolean isOneEditDistance(String s, String t) {
    for (int i = 0; i < Math.min(s.length(), t.length()); i++) {
      if (s.charAt(i) != t.charAt(i)) {
        if (s.length() == t.length()) return s.substring(i + 1).equals(t.substring(i + 1));
        else if (s.length() > t.length()) return s.substring(i + 1).equals(t.substring(i));
        else return s.substring(i).equals(t.substring(i + 1));
      }
    }
    return Math.abs(s.length() - t.length()) == 1;
  }

  public static void main(String[] args) {
    Prob161 prob161 = new Prob161();
//    System.out.println(prob161.isOneEditDistance("a", "A"));
    System.out.println(prob161.isOneEditDistance("ab", "cab"));
    System.out.println(prob161.isOneEditDistance("a", ""));
  }
}
