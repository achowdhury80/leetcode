package com.leet.algo;

import java.util.Arrays;

/**
 * Created by ayanc on 12/29/17.
 */
public class Prob151 {
  public String reverseWords(String s) {
    if(s == null || s.trim().length() == 0) return "";
    char[] chars = new char[s.length()];
    int j = 0;
    boolean lastCharacterSpace = false;
    for(int i = s.length() - 1; i > -1; i--){
      if(s.charAt(i) == ' '){
        if(j == 0 || lastCharacterSpace) continue;
        chars[j++] = ' ';
        lastCharacterSpace = true;
      } else {
        lastCharacterSpace = false;
        int lastCharIndex = i;
        int k = i;
        while(k > -1 && s.charAt(k) != ' '){
          k--;
        }
        k++;
        i = k;
        while(k <= lastCharIndex){
          chars[j++] = s.charAt(k);
          k++;
        }
      }
    }
    return String.valueOf(chars, 0, j).trim();
  }

  public static void main(String[] args){
    Prob151 prob151 = new Prob151();
    System.out.println(prob151.reverseWords("a  b c  d  "));
    System.out.println(prob151.reverseWords("hi!"));
    System.out.println(prob151.reverseWords(" 1"));
  }
}
