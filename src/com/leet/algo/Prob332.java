package com.leet.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

/**
 * Created by ayanc on 1/16/18.
 */
public class Prob332 {
  public List<String> findItinerary(String[][] tickets) {
    Map<String, List<String>> map = new HashMap<>();
    for(String[] ticket : tickets){
      if(!map.containsKey(ticket[0])) map.put(ticket[0], new ArrayList<>());
      map.get(ticket[0]).add(ticket[1]);
      Collections.sort(map.get(ticket[0]));
    }
    List<String> response = new ArrayList<>();
    response.add("JFK");
    dfs("JFK", map, response);
    return response;
  }

  private boolean dfs(String start, Map<String, List<String>> map, List<String> response) {
    if (map.isEmpty()) return true;
    if (!map.containsKey(start) || map.get(start).isEmpty()) return false;
    List<String> nextList = map.get(start);

    for(int i = 0; i < nextList.size(); i++) {
      String next = nextList.get(i);
      response.add(next);
      nextList.remove(i);
      if (nextList.size() == 0) map.remove(start);
      if (dfs(next, map, response)) return true;
      nextList.add(i, next);
      if (!map.containsKey(start)) map.put(start, nextList);
      response.remove(response.size() - 1);
    }
    return false;
  }

  public static void main(String[] args) {
    Prob332 prob332 = new Prob332();
    System.out.println(prob332.findItinerary(new String[][]{{"MUC", "LHR"}, {"JFK", "MUC"}, {"SFO", "SJC"}, {"LHR", "SFO"}}));
    System.out.println(prob332.findItinerary(new String[][]{{"JFK","SFO"}, {"JFK","ATL"}, {"SFO","ATL"}, {"ATL","JFK"}, {"ATL","SFO"}}));
    System.out.println(prob332.findItinerary(new String[][]{{"JFK","KUL"}, {"JFK","NRT"}, {"NRT","JFK"}}));
  }
}
