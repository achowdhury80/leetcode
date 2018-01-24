package com.leet.algo;

/**
 * Created by ayanc on 1/22/18.
 */
public class Prob767 {
  public String reorganizeString(String S) {
    if(S == null || S.length() < 2) return S;
    int[] chars = new int[26];
    for(int i = 0; i < S.length(); i++){
      chars[S.charAt(i) - 'a']++;
    }
    String result = "";
    Character c = findNextChar(chars, null);
    result += c;
    chars[c - 'a']--;
    char lastChar = c;
    while (result.length() < S.length()){
      c = findNextChar(chars, lastChar);
      if(c == null) return "";
      lastChar = c;
      result += c;
      chars[c - 'a']--;
    }
    return result;
  }

  private Character findNextChar(int[] chars, Character avoid){
    int maxIndex = -1;
    for(int i = 0; i < 26; i++){
      if(chars[i] != 0  && (avoid == null || i != avoid - 'a') && (maxIndex == -1 || chars[i] > chars[maxIndex])){
        maxIndex = i;
      }
    }
    if(maxIndex == -1) return null;
    return (char)(maxIndex + 'a');
  }

  public static void main(String[] args){
    Prob767 prob767 = new Prob767();
    System.out.println(prob767.reorganizeString("aab"));
    System.out.println(prob767.reorganizeString("aaab"));
  }
}
