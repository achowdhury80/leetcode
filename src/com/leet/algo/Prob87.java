package com.leet.algo;

/**
 * Created by ayanc on 2/28/18.
 */
public class Prob87 {
  public boolean isScramble(String s1, String s2) {
    if (s1 == null || s2 == null || s1.length() < 0 || s2.length() < 0 || s1.length() != s2.length()) return false;
    if (s1.equals(s2)) return true;
    int[] arr = new int[26];

    for (int i = 0; i < s1.length(); i++) arr[s1.charAt(i) - 'a']++;
    for (int i = 0; i < s2.length(); i++) {
      if (arr[s2.charAt(i) - 'a'] == 0) return false;
      arr[s2.charAt(i) - 'a']--;
    }
    for (int i = 1; i < s1.length(); i++) {
      if (isScramble(s1.substring(0, i), s2.substring(0, i)) && isScramble(s1.substring(i), s2.substring(i))) return true;
      if (isScramble(s1.substring(0, i), s2.substring(s2.length() - i))
          && isScramble(s1.substring(i), s2.substring(0, s2.length() - i))) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    Prob87 prob87 = new Prob87();
    System.out.println(prob87.isScramble("ab", "ba"));
  }
}
