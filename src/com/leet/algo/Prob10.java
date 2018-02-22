package com.leet.algo;

/**
 * Created by ayanc on 2/20/18.
 */
public class Prob10 {
  public boolean isMatch(String s, String p) {
    if ("".equals(p)) {
      if (s.length() > 0) return false;
      return true;
    }
    if (p.length() > 1 && p.charAt(1) == '*') {
      if (s.length() < 1) return isMatch(s, p.substring(2));
      if (isMatch(s, p.substring(2))) return true;
      if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') return isMatch(s.substring(1), p);
      return false;
    } else {
      if (s.length() < 1) return false;
      if (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.') return isMatch(s.substring(1), p.substring(1));
      return false;
    }
  }

  public static void main(String[] args) {
    System.out.println("".substring(0));
    Prob10 prob10 = new Prob10();
    System.out.println(prob10.isMatch("aa","a"));
    System.out.println(prob10.isMatch("aa","aa"));
    System.out.println(prob10.isMatch("aaa","aa"));
    System.out.println(prob10.isMatch("aa", "a*"));
    System.out.println(prob10.isMatch("aa", ".*"));
    System.out.println(prob10.isMatch("ab", ".*"));
    System.out.println(prob10.isMatch("aab", "c*a*b"));
    System.out.println(prob10.isMatch("aaba", "ab*a*c*a"));
    System.out.println(prob10.isMatch("a", "ab*"));
    System.out.println(prob10.isMatch("ab", ".*c"));
  }


}
