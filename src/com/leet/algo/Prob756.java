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
    List<String> currentLevel = new ArrayList<>();
    currentLevel.add(bottom);
    for(int i = 1; i < numberOfLevels && currentLevel.size() > 0; i++){
      List<String> nextLevels = new ArrayList<>();
      for(String s : currentLevel){
        List<String> nextlevel = nextLevels(s, map);
        if(!nextlevel.isEmpty())
          nextLevels.addAll(nextlevel);
      }
      currentLevel = nextLevels;
    }
    return currentLevel.size() > 0;

  }

  private List<String> nextLevels(String upperLevel, Map<String, List<String>> map){
    List<String> result = new ArrayList<>();
    if(upperLevel.length() == 2){
      if(map.containsKey(upperLevel)) result.addAll(map.get(upperLevel));
      return result;
    } else if(upperLevel.length() == 3){
      String left = upperLevel.substring(0,2);
      String right = upperLevel.substring(1,3);
      if(!map.containsKey(left) || !map.containsKey(right)) return result;
      List<String> leftList = map.get(left);
      List<String> rightList = map.get(right);
      result.addAll(merge(leftList, rightList));
      return result;
    }
    else {
      String left = upperLevel.substring(0,upperLevel.length() / 2 + 1);
      String right = upperLevel.substring(upperLevel.length() / 2, upperLevel.length());
      List<String> leftList = nextLevels(left, map);
      List<String> rightList = nextLevels(right, map);
      if(!leftList.isEmpty() && !rightList.isEmpty())result.addAll(merge(leftList, rightList));
      return result;
    }
  }

  private List<String> merge(List<String> list1, List<String> list2){
    List<String> result = new ArrayList<>();
    if(list1.isEmpty() || list2.isEmpty()) return result;
    for(String l : list1) for(String r : list2) result.add(l + r);
    return result;
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
