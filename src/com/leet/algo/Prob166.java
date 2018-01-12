package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 1/11/18.
 */
public class Prob166 {
  public String fractionToDecimal(int numerator, int denominator) {
    if(numerator == 0) return "0";
    String result = "";
    long n = numerator + 0l;
    long d = denominator + 0l;
    if(n < 0 && d < 0){
      n *= -1;
      d *= -1;
    } else if(n < 0){
      result += "-";
      n *= -1;
    } else if(d < 0l){
      result += "-";
      d *= -1;
    }
    if(d == 1) return result + n;

   long k = 0;
    if((k = n / d) > 0){
      result += k;
      n = n - d * k;
    }
    if(n == 0) return result;
    if("".equals(result) || "-".equals(result)) result += "0.";
    else result +=".";
    long l = n + 0l;
    Map<Long, Integer> map = new HashMap<>();
    long i = 0;
    while(l != 0){
      l *= 10;
      long j = l;
      if(map.containsKey(l)){
        result = result.substring(0, map.get(l)) + "("  + result.substring(map.get(l)) + ")";
        return result;
      }
      if(l < d){
        result += 0;
        map.put(j, result.length() - 1);
        continue;
      }
      i = l / d;
      result += i;
      map.put(j, result.length() - 1);
      l = l - i * d;
    }
    return result;
  }

  public static void main(String[] args){
    Prob166 prob166 = new Prob166();
//    System.out.println(prob166.fractionToDecimal(1, 2));
//    System.out.println(prob166.fractionToDecimal(2, 1));
//    System.out.println(prob166.fractionToDecimal(2, 3));
//    System.out.println(prob166.fractionToDecimal(1, 90));
//    System.out.println(prob166.fractionToDecimal(1, 99));
//    System.out.println(prob166.fractionToDecimal(22, 7));
//    System.out.println(prob166.fractionToDecimal(-1, -2147483648));
    System.out.println(prob166.fractionToDecimal(-50, 8));

  }

}
