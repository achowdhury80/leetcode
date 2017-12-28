package com.leet.algo;

/**
 * Created by ayanc on 12/27/17.
 */
public class Prob680 {
  public boolean validPalindrome(String s) {
    if(s == null || s.length() == 0) return false;
    if(s.length() < 2) return true;
    int i = -1, j = s.length();
    while (i < j){
      i++;
      j--;
      if(s.charAt(i) != s.charAt(j)){
        return isPalindrome(s, i + 1, j) || isPalindrome(s, i, j - 1);
      }
    }
    return true;
  }

  private boolean isPalindrome(String s, int start, int end){
    while(start < end){
      if(s.charAt(start) != s.charAt(end)) return false;
      start++;
      end--;
    }
    return true;
  }

  public static void main(String[] args){
    Prob680 prob680 = new Prob680();
//    System.out.println(prob680.validPalindrome("aba"));
//    System.out.println(prob680.validPalindrome("abca"));
//    System.out.println(prob680.validPalindrome("eedede"));

    System.out.println(prob680.validPalindrome("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga"));
  }

}
