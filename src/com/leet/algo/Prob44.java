package com.leet.algo;

/**
 * Created by ayanc on 2/20/18.
 */
public class Prob44 {
  //O(s.Length * p.Length)
  public boolean isMatch(String s, String p) {
    int sp = 0, pp = 0, match = -1, startIdx = -1;
    while(sp < s.length()) {
      if (pp < p.length() && (s.charAt(sp) == p.charAt(pp) || p.charAt(pp) == '?')) {
        sp++;
        pp++;
      } else if (pp < p.length() && p.charAt(pp) == '*') {
        startIdx = pp;
        match = sp;
        pp++;
      } else if (startIdx != -1) {
        pp = startIdx + 1;
        match++;
        sp = match;
      } else return false;
    }
    while (pp < p.length() && p.charAt(pp) == '*') pp++;
    return pp == p.length();
  }

  public static void main(String[] args) {
    Prob44 prob44 = new Prob44();
    System.out.println(prob44.isMatch("aa","a"));
    System.out.println(prob44.isMatch("aa","aa"));
    System.out.println(prob44.isMatch("aaa","aa"));
    System.out.println(prob44.isMatch("aa", "*"));
    System.out.println(prob44.isMatch("aa", "a*"));
    System.out.println(prob44.isMatch("ab", "?*"));
    System.out.println(prob44.isMatch("aab", "c*a*b"));
  }
}
