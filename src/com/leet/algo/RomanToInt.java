package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 7/11/17.
 */
public class RomanToInt {
  private static Map<Character, Integer> map = new HashMap();
  static{
    map.put('I',1);
    map.put('V', 5);
    map.put('X', 10);
    map.put('L', 50);
    map.put('C', 100);
    map.put('D', 500);
    map.put('M', 1000);
  }

  public static void main(String[] args){
    RomanToInt romanToInt = new RomanToInt();
    System.out.println(romanToInt.romanToInt("MMMCMXCIX"));
  }

  public int romanToInt(String s) {
    Character previousChar = null;
    int sum = 0;
    for(int i = 0; i < s.length(); i++){
      if(previousChar != null && map.get(s.charAt(i)) > map.get(previousChar) ){
        sum  -= map.get(previousChar);
      } else if(previousChar != null){
        sum += map.get(previousChar);
      }
      previousChar = s.charAt(i);
    }
    sum += map.get(previousChar);
    return sum;
  }
}
