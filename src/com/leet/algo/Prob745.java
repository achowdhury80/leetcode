package com.leet.algo;

/**
 * Created by ayanc on 1/3/18.
 */
public class Prob745 {
  public char nextGreatestLetter(char[] letters, char target) {
    for(int i = 0; i < letters.length; i++){
      if(letters[i] > target) return letters[i];
    }
    return letters[0];
  }

}
