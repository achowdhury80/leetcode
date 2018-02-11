package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob751 {
  public List<String> ipToCIDR(String ip, int n) {
    int num = ipToNumber(ip);
    List<String> result = new ArrayList<>();
    while (n > 0) {
      if (n == 1) {
        result.add(intToIp(num) + "/" + 32);
        break;
      }
      int trailZeors = findTrailingZeros(num);
      if (trailZeors == 0) {
        result.add(intToIp(num) + "/" + 32);
        n--;
        num++;
      } else {
        int start = 1;
        int i = 1;
        for (; i <= trailZeors; i++) {
          start *= 2;
          if (n < start) {
            start /= 2;
            break;
          }
        }
        i--;
        result.add(intToIp(num) + "/" + (32 - i));
        num += start;
        n -= start;
      }
    }
    return result;
  }

  private int ipToNumber(String ip) {
    String[] strs = ip.split("\\.");
    int result = 0;
    for (int i = 0; i < 4; i++) {
      result = result << 8;
      int ipBlock = Integer.parseInt(strs[i]);
      result += ipBlock;
    }
    return result;
  }

  private int findTrailingZeros(int num) {
    int result = 0;
    int i = 1;
    int j = 0;
    while(j < 32 && (num & i) == 0){
      j++;
      result++;
      i <<= 1;
    }
    return result;
  }

  private String intToIp(int number) {
    int mask = 255;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < 4; i++) {
      result.insert(0, "." + (number & mask));
      number >>= 8;
    }
    result.deleteCharAt(0);
    return result.toString();
  }

  public static void main(String[] args) {
    Prob751 prob751 = new Prob751();
//    System.out.println(prob751.ipToNumber("255.0.0.7"));
//    System.out.println(prob751.intToIp(-16777209));
//    System.out.println(prob751.findTrailingZeros(10));
    System.out.println(prob751.ipToCIDR("255.0.0.7", 10));
  }
}
