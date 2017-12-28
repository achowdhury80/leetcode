package com.leet.algo;

/**
 * Created by ayanc on 9/15/17.
 */
public class Prob541 {
  public String reverseStr(String s, int k) {
    if(s == null || s.length() == 0 || k < 2) return s;
    int count = 0;
    String result = s;
    for(int i = 0; i < s.length() - 1; count++){
      i = count * k;
      if(count % 2 == 0){
        int end = (i + k) <= s.length() ? (i + k - 1) : s.length() - 1;
        if(i < end){
          result = reverse(result, i, end);
        }
      }
    }
    return result;
  }
  private String reverse(String s, int start, int end){
    String prefix = "";
    String suffix = "";
    if(start != 0) prefix = s.substring(0, start);
    if(end != s.length() - 1) suffix = s.substring(end + 1);
    new StringBuilder(s.substring(start , end + 1)).reverse().toString();
    String result = prefix + new StringBuilder(s.substring(start , end + 1)).reverse().toString() + suffix;
    return  result.toString();
  }

  public static void main(String[] args){
    System.out.println(new Prob541().reverseStr("abcdefghijklmn", 3));
  }
}
