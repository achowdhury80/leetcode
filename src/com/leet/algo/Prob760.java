package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 1/9/18.
 */
public class Prob760 {
  public int[] anagramMappings(int[] A, int[] B) {
    int[] result = new int[A.length];
    Map<Integer, List<Integer>> map = new HashMap<>();
    IntStream.range(0, B.length).forEach(x -> {
      int b = B[x];
      if(map.containsKey(b)){
        map.get(b).add(x);
      } else {
        List<Integer> list = new ArrayList<Integer>();
        list.add(x);
        map.put(b, list);
      }
    });
    for (int i = 0; i < A.length; i++){
      result[i] = map.get(A[i]).remove(0);
    }
    return result;
  }
}
