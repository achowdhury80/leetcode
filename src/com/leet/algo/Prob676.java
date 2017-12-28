package com.leet.algo;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 12/8/17.
 */
public class Prob676 {
  private Set<String> set;
  public Prob676() {

  }

  /** Build a dictionary through a list of words */
  public void buildDict(String[] dict) {
    if(dict == null || dict.length == 0) return;

    for(int i = 0; i < dict.length; i++){
      String word = dict[i];
      if(word.length() < 1) continue;;
      if(word.length() == 1) {
        set.add("");
        continue;
      }
      set.add(word.substring(1,word.length()));
      set.add(word.substring(0, word.length() - 1));
      if(word.length() < 3) continue;
      for(int j = 1; j < word.length() - 1; j++){
        set.add(word.substring(0, j) + word.substring(j + 1));
      }
    }
  }

  /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
  public boolean search(String word) {
    if(word == null || word.length() == 0) return false;
    if(word.length() == 1) return set.contains("");
    if(set.contains(word.substring(1))) return true;
    if(set.contains(word.substring(0, word.length() - 1))) return true;
    if(word.length() == 2) return false;
    for(int i = 1; i < word.length() - 1; i++){
      if(set.contains(word.substring(0, i) + word.substring(i + 1))) return true;
    }
    return false;
  }
}
