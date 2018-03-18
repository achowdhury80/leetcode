package com.leet.algo;

/**
 * Created by ayanc on 3/11/18.
 */
public class Prob125 {
  public boolean isPalindrome(String s){
    if (s == null) return false;
    int i = 0, j = s.length() - 1;
    while (i < j) {
      if (!Character.isLetter(s.charAt(i)) && !Character.isDigit(s.charAt(i))) i++;
      else if (!Character.isLetter(s.charAt(j)) && !Character.isDigit(s.charAt(j))) j--;
      else if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
      else {
        i++;
        j--;
      }
    }
    return true;
  }
}
