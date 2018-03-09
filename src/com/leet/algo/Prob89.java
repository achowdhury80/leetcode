package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by ayanc on 11/8/17.
 */
public class Prob89 {
  public List<Integer> grayCode(int n) {
    List<Integer> result = new ArrayList<>();
    if(n == 0) return Arrays.asList(new Integer[]{0});
    for (int i = 0; i < 1 << n; i++) result.add(i ^ (i >> 1));
    return result;
  }

  public static void main(String[] args) {
    Prob89 prob87 = new Prob89();
    //System.out.println(prob87.grayCode(2));
    System.out.println(prob87.grayCode(3));
    //System.out.println(prob87.toInteger("01"));
  }


}
