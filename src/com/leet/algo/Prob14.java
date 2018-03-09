package com.leet.algo;

/**
 * Created by ayanc on 3/4/18.
 */
public class Prob14 {
  public String longestCommonPrefix(String[] strs) {
    if(strs == null || strs.length == 0) return "";
    String prefix = strs[0];
    for(int i = 1; i < strs.length; i++){
      if(!strs[i].startsWith(prefix)){
        int j = 0;
        while(j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)){
          j++;
        }
        if(j < 1) return "";
        prefix = prefix.substring(0, j);
      }

    }
    return prefix;
  }
}
