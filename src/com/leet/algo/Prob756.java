package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 1/23/18.
 */
public class Prob756 {
  public boolean pyramidTransition(String bottom, List<String> allowed) {
    if(allowed == null || allowed.size() < 1 || bottom == null || bottom.length() < 2) return false;
    int numberOfLevels = bottom.length();
    Map<String, List<String>> map = generateOneLevelUp(allowed);
    Map<String, Boolean> resolvedMap = new HashMap<>();
    for (String key : map.keySet()) resolvedMap.put(key, true);
    return pyramidTransition(bottom, map, resolvedMap);
  }

  public boolean pyramidTransition(String bottom, Map<String, List<String>> map, Map<String, Boolean> resolvedMap) {
    if (bottom.length() == 1) return true;
    if (resolvedMap.containsKey(bottom)) return resolvedMap.get(bottom);
    for (int i = 0; i < bottom.length() - 1; i++) {
      if (!map.containsKey(bottom.substring(i, i + 2))) {
        resolvedMap.put(bottom, false);
        return false;
      }
    }
    List<String> nextLevels = nextLevels(bottom, 0, map, new ArrayList<>());
    for (String st : nextLevels) {
      if (pyramidTransition(st, map, resolvedMap)) {
        resolvedMap.put(bottom, true);
        return true;
      }
    }
    resolvedMap.put(bottom, false);
    return false;
  }

  private List<String> nextLevels(String bottom, int index, Map<String, List<String>> map, List<String> list) {
    if (index == bottom.length() - 1) return list;
    List<String> result = new ArrayList<>();
    for (String s : map.get(bottom.substring(index, index + 2))) {
      if (list.isEmpty()) result.add(s);
      else {
        for (String s1 : list) {
          result.add(s1 + s);
        }
      }
    }
    return nextLevels(bottom, index + 1, map, result);
  }

  private Map<String, List<String>> generateOneLevelUp(List<String> allowed){
    Map<String, List<String>> map = new HashMap<>();
    for(String s : allowed){
      String base = s.substring(0, 2);
      if(!map.containsKey(base)) map.put(base, new ArrayList<>());
      map.get(base).add(s.charAt(2) + "");
    }
    return map;
  }

  public static void main(String[] args){
    Prob756 prob756 = new Prob756();
    System.out.println(prob756.pyramidTransition("XYZ", Arrays.asList(new String[]{"XYD", "YZE", "DEA", "FFF"})));
    System.out.println(prob756.pyramidTransition("XXYX", Arrays.asList(new String[]{"XXX", "XXY", "XYX", "XYY", "YXZ"})));
    System.out.println(prob756.pyramidTransition("ABC", Arrays.asList(new String[]{"ABD","BCE","DEF","FFF"})));

  }
}
