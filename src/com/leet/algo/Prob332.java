package com.leet.algo;

import java.util.ArrayList;
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
      if(!map.containsKey(ticket[0])) map.put(ticket[0], new TreeSet<>());
      map.get(ticket[0]).add(ticket[1]);
    }

    return null;
  }

  private List<String> dfs(Map<String, TreeSet<String>> map, String start, int numberOfTickets){
    List<String> path = new ArrayList<>();
    path.add(start);
    if(path.size() == numberOfTickets + 1) return path;
    if(map.get(start).size() == 0) return null;
    else {
      for(String next : map.get(start)){
        List<String> nextPaths = dfs(map, next, numberOfTickets);
        if(nextPaths == null) continue;
      }
    }
    return null;
  }
}
