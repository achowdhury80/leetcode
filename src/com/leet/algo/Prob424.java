package com.leet.algo;

/**
 * Created by ayanc on 1/23/18.
 */
public class Prob424 {
  public int characterReplacement(String s, int k) {
    if(s == null || s.length() < 1) return 0;
    int[] count = new int[26];
    int end = 0, start = 0, len = s.length();
    int maxCount = 0, maxLength = 0;
    for(end = 0; end < len; end++){
      maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);
      while (end - start + 1 - maxCount > k){
        count[s.charAt(start) - 'A']--;
        start++;
      }
      maxLength = Math.max(maxLength, end - start + 1);
    }
    return maxLength;
  }
}
