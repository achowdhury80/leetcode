package com.leet.algo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by ayanc on 1/16/18.
 */
public class Prob332 {
  public List<String> findItinerary(String[][] tickets) {
    Map<String, TreeSet<String>> map = new HashMap<>();
    for(String[] ticket : tickets){
      if(map.containsKey(ticket[0])){
        map.get(ticket[0]).add(ticket[1]);
      } else {
        //TreeSet<String> treeSet
      }
    }
    return null;
  }
}
