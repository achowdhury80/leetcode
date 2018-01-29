package com.leet.algo;

import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/28/18.
 */
public class Prob771 {
  public int numJewelsInStones(String J, String S) {
    int[] chars = new int[58];
    IntStream.range(0, S.length()).forEach(idx -> chars[S.charAt(idx) - 'A']++);
    int result = 0;
    for (int i = 0; i < J.length(); i++){
      result += chars[J.charAt(i) - 'A'];
    }
    return result;
  }

  public static void main(String[] args){
    Prob771 prob771 = new Prob771();
    System.out.println(prob771.numJewelsInStones("z", "ZZ"));
  }
}
