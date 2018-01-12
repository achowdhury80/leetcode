package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 1/10/18.
 */
public class Prob423 {

  public String originalDigits(String s) {
    int[] count = new int[10];
    for(int i = 0; i < s.length(); i++){
      char c = s.charAt(i);
      if(c == 'z') count[0]++;
      if (c == 'w') count[2]++;
      if (c == 'u') count[4]++;
      if (c == 'x') count[6]++;
      if (c == 'g') count[8]++;
      if (c == 't') count[3]++;
      if (c == 'o') count[1]++;
      if (c == 'f') count[5]++;
      if (c == 's') count[7]++;
      if (c == 'n') count[9]++;
    }
    count[1] -= (count[0] + count[2] + count[4]);
    count[3] -= (count[2] + count[8]);
    count[5] -= count[4];
    count[7] -= count[6];
    count[9] = (count[9] - count[7] - count[1]) / 2;
    String result = "";
    for(int i = 0; i < 10; i++){
      for(int j = 0; j < count[i]; j++) result += i;
    }
    return result;
  }

  public static void main(String[] args){
    Prob423 prob423 = new Prob423();
//    System.out.println(prob423.originalDigits("owoztneoer"));
//    System.out.println(prob423.originalDigits("fviefuro"));
    System.out.println(prob423.originalDigits("owoztneoer"));
  }
}
