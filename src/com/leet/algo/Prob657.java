package com.leet.algo;

/**
 * Created by ayanc on 8/15/17.
 */
public class Prob657 {
  public boolean judgeCircle(String moves) {
    if(moves == null || moves.length() < 2) return false;
    int udScore = 0;
    int lrScore = 0;
    for(int i = 0; i < moves.length(); i++){
      if('U' == moves.charAt(i)) udScore++;
      if('D' == moves.charAt(i)) udScore--;
      if('L' == moves.charAt(i)) lrScore++;
      if('R' == moves.charAt(i)) lrScore--;
    }
    return udScore == 0 && lrScore == 0;
  }
}
