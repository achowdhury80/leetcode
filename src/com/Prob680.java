package com;

/**
 * Created by ayanc on 10/20/17.
 */
public class Prob680 {
  public boolean validPalindrome(String s) {
    return validPalindrome(s, false);
  }
  public boolean validPalindrome(String s, boolean used) {
    if(s == null || s.length() < 2) return true;
    if(s.length() == 2){
      if(!used) return true;
      else return s.charAt(0) == s.charAt(1);
    }
    if(s.charAt(0) == s.charAt(s.length() - 1)){
      return validPalindrome(s.substring(1, s.length() - 1), used);
    } else if(used){
      return false;
    } else {
      return validPalindrome(s.substring(0, s.length() - 2), true) || validPalindrome(s.substring(1, s.length() - 1), true);
    }
  }

  public static void main(String[] args){
    Prob680 prob680 = new Prob680();
    System.out.println(prob680.validPalindrome("aba"));
    System.out.println(prob680.validPalindrome("abca"));
    System.out.println(prob680.validPalindrome("abcdefdcba"));
  }
}
