package com.leet.algo;

/**
 * Created by ayanc on 2/23/18.
 */
public class Prob383 {
  public boolean canConstruct(String ransomNote, String magazine) {
    if(ransomNote == null || magazine == null
        || ransomNote.length() > magazine.length()) return false;
    if(magazine.length() == 0 || ransomNote.length() == 0) return true;
    int[] chars = new int[26];
    int j = -1;
    int count = ransomNote.length();
    for(int i = 0; i < ransomNote.length(); i++) chars[ransomNote.charAt(i) - 'a']++;
    for (int i = 0; i < magazine.length(); i++) {
      int k = magazine.charAt(i) - 'a';
      if (chars[k] > 0) {
        count--;
        chars[k]--;
        if (count == 0) return true;
      }
    }
    return false;
  }
}
