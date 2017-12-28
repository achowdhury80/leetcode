package com.leet.algo;

/**
 * Created by ayanc on 12/27/17.
 */
public class Prob696 {
  public int countBinarySubstrings(String s) {
    if(s == null || s.length() < 2) return 0;
    int startIndex = 0;
    int changeIndex = -1;
    int result = 0;
    int mode = 0; //starting mode
    for(int i = 1; i < s.length(); i++){
      if(mode == 0){
        if(s.charAt(i - 1) != s.charAt(i)){
          changeIndex = i;
          mode = 1; //balancing
          result++;
        }
      }
      else{
        if(s.charAt(i - 1) != s.charAt(i)){
          startIndex = changeIndex;
          changeIndex = i;
          result++;
        } else {
          int leftNumbers = changeIndex - startIndex;
          int rightNumbers = i - changeIndex + 1;
          if(rightNumbers <= leftNumbers){
            result++;
          }else {
            mode = 0;
            startIndex = changeIndex;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob696 prob696 = new Prob696();
    System.out.println(prob696.countBinarySubstrings("00110011"));
    System.out.println(prob696.countBinarySubstrings("10101"));
  }
}
