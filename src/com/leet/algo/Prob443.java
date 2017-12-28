package com.leet.algo;

/**
 * Created by ayanc on 12/27/17.
 */
public class Prob443 {
  public int compress(char[] chars) {
    if(chars == null || chars.length == 0) return 0;
    if(chars.length < 2) return chars.length;
    int count = 1;
    int currentIdx = -1;
    for(int i = 1; i < chars.length; i++){
      if(chars[i] == chars[i - 1]){
        count++;
      } else {
        if(count > 1){
          chars[++currentIdx] = chars[i - 1];
          currentIdx = populate(chars, currentIdx, count);
          count = 1;
        } else {
          chars[++currentIdx] = chars[i - 1];
          count = 1;
        }
      }
    }
    chars[++currentIdx] = chars[chars.length - 1];
    if(count > 1){
      currentIdx = populate(chars, currentIdx, count);
    }
    return currentIdx + 1;
  }

  private int populate(char[] chars, int lastIndex, int count){
    String countStr = String.valueOf(count);
    for(int i = 0; i < countStr.length(); i++){
      chars[lastIndex + i + 1] = countStr.charAt(i);
    }
    return lastIndex + countStr.length();
  }

  public static void main(String[] args){
    Prob443 prob443 = new Prob443();
    System.out.println(prob443.compress(new char[]{'a','a','b','b','c','c','c'}));
  }
}
