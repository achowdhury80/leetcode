package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 12/7/17.
 */
public class Prob739 {
  public int[] dailyTemperatures(int[] temperatures) {
    if(temperatures == null || temperatures.length < 1) return temperatures;
    int[] result = new int[temperatures.length];
    Map<Integer, Integer> temperatureLocation = new HashMap<>();
    for(int i = temperatures.length - 1; i > -1; i--){
      List<Integer> list = new ArrayList<>();
      for(int j = temperatures[i] + 1; j <= 100; j++){
        if(temperatureLocation.containsKey(j)){
          list.add(temperatureLocation.get(j));
        }
      }
      if(!list.isEmpty()){
        Collections.sort(list);
        result[i] = list.get(0) - i;
      }
      temperatureLocation.put(temperatures[i], i);
    }
    return result;
  }

  public static void main(String[] args){
    Prob739 prob739 = new Prob739();
    Arrays.stream(prob739.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})).forEach(System.out::println);
  }
}
