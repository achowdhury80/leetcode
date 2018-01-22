package com.leet.algo;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob567 {
  public boolean checkInclusion(String s1, String s2) {
    if(s1 == null || s1.length() < 1 || s2 == null || s2.length() < 1 || s1.length() > s2.length()) return false;
    int[] s1Map = new int[26];
    char[] chars = s1.toCharArray();
    for(int i = 0; i < chars.length; i++) s1Map[chars[i] - 'a'] += 1;
    int[] s2Map = new int[26];
    int s1Length = s1.length();
    chars = s2.toCharArray();
    for(int i = 0; i < s1Length; i++) s2Map[chars[i] - 'a'] += 1;
    if(isEqual(s1Map, s2Map)) return true;
    for(int i = 1; i + s1Length <= s2.length(); i++){
      char old = s2.charAt(i - 1);
      char newC = s2.charAt(i + s1Length - 1);
      s2Map[old - 'a']--;
      s2Map[newC - 'a']++;
      if(isEqual(s1Map, s2Map)) return true;
    }
    return false;
  }

  private boolean isEqual(int[] s1Map, int[] s2Map){
    for(int i = 0; i < 26; i++) if(s1Map[i] != s2Map[i]) return false;
    return true;
  }

  public static void main(String[] args){
    Prob567 prob567 = new Prob567();
    System.out.println(prob567.checkInclusion("ab", "eidbaooo"));
    System.out.println(prob567.checkInclusion("ab", "eidboaoo"));
  }
}
