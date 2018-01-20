package com.leet.algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 1/20/18.
 */
public class Prob554 {
  public int leastBricks(List<List<Integer>> wall) {
    if(wall == null || wall.size() < 1) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    for(int i = 0; i < wall.size(); i++){
      List<Integer> list = wall.get(i);
      int sum = 0;
      for(int j = 1; j < list.size(); j++){
        sum += list.get(j - 1);
        map.put(sum, map.getOrDefault(sum, 0) + 1);
      }
    }
    int max = Integer.MIN_VALUE;
    for(Integer key : map.keySet()) max = Math.max(max, map.get(key));
    return wall.size() - (max == Integer.MIN_VALUE ? 0 : max);
  }


}
