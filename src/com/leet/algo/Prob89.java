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
    String straingCode = "";
    for (int i = 0; i < n; i++) {
      straingCode += '0';
    }
    return grayCode(n, straingCode).stream().map(x -> toInteger(x)).collect(Collectors.toList());
  }

  private List<String> grayCode(int n, String startingCode) {
    List<String> result = new ArrayList<>();
    if (n == 0) return null;
    result.add(startingCode);
    for (int i = n - 1; i > -1; i--) {
      String prefix = "";
      if (i > 0) prefix = startingCode.substring(0, i);
      prefix += startingCode.charAt(i) == '1' ? '0' : '1';
      List<String> suffixList = grayCode(n - i - 1, startingCode.substring(i + 1));
      if (suffixList == null) {
        result.add(prefix);
      } else {
        for (String suffix : suffixList) {
          result.add(prefix + suffix);
        }
      }
      startingCode = result.get(result.size() - 1);

    }
    return result;
  }

  private Integer toInteger(String grayCode) {
    Integer result = 0;
    int pow = 0;
    for (int i = grayCode.length() - 1; i > -1; i--) {
      if (grayCode.charAt(i) == '1') {
        result += Double.valueOf(Math.pow(2, pow)).intValue();
      }
      pow++;
    }
    return result;
  }


  public static void main(String[] args) {
    Prob89 prob87 = new Prob89();
    System.out.println(prob87.grayCode(2));
    //System.out.println(prob87.toInteger("01"));
  }


}
