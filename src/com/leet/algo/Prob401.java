package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ayanc on 9/13/17.
 */
public class Prob401 {
  public List<String> readBinaryWatch(int num) {
    ArrayList<String> result = new ArrayList<>();
    for (int i = 0; i < 12; i++) {
      for (int j = 0; j < 60; j++) {
        if (Integer.bitCount(i) + Integer.bitCount(j) == num) {
          result.add(String.format("%d:%02d", i, j));
        }
      }
    }
    return result;
  }

  public static void main(String[] args){
    System.out.println(new Prob401().readBinaryWatch(2));
  }


}
