package com.leet.algo;

/**
 * Created by ayanc on 8/15/17.
 */
public class Prob557 {
  public String reverseWords(String s) {
    if(s == null || s.length() < 2) return s;
    String[] strs = s.split(" ");
    String result = "";
    for(int i = 0; i < strs.length; i++)  result = result + " " + reverseWord(strs[i]);
    return result.substring(1);
  }

  private String reverseWord(String word){
    String result = "";
    for(int i = word.length() - 1; i > -1; i--){
      result += word.charAt(i);
    }
    return result;
  }
}
