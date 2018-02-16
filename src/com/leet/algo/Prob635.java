package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 2/15/18.
 */
public class Prob635 {

  private List<String[]> timestamps;
  List<String> granularities = Arrays.asList("Year", "Month", "Day", "Hour", "Minute", "Second");
  int[] index = new int[]{4, 7, 10, 13, 16, 19};

  public Prob635() {
    timestamps = new ArrayList<>();
  }

  public void put(int id, String timestamp) {
    timestamps.add(new String[]{"" + id, timestamp});
  }

  public List<Integer> retrieve(String s, String e, String gra) {
    Set<Integer> set = new HashSet<>();
    int idx = index[granularities.indexOf(gra)];
    for (String[] timestamp : timestamps) {
      String subStr = timestamp[1].substring(0, idx);
      if (subStr.compareTo(s.substring(0, idx)) >= 0 && subStr.compareTo(e.substring(0, idx)) <= 0) set.add(Integer.parseInt(timestamp[0]));
    }
    return new ArrayList<>(set);
  }


//  private Map<Long, Set<Integer>> map;
//  private String start = "0101000000";
//  private String end = "1231235959";
//  public Prob635() {
//    map = new HashMap<>();
//  }
//
//  public void put(int id, String timestamp) {
//    long time = timeStapToLong(timestamp);
//    if (!map.containsKey(time)) map.put(time, new HashSet<>());
//    map.get(time).add(id);
//  }
//
//  public List<Integer> retrieve(String s, String e, String gra) {
//    switch (gra){
//      case "Second" : return retrieve(timeStapToLong(s), timeStapToLong(e));
//      case "Minute" : return retrieve(timeStapToLong(mask(s, start.substring(8))), timeStapToLong(mask(e, end.substring(8))));
//      case "Hour": return retrieve(timeStapToLong(mask(s,start.substring(6))), timeStapToLong(mask(e,end.substring(6))));
//      case "Day": return retrieve(timeStapToLong(mask(s,start.substring(4))), timeStapToLong(mask(e,end.substring(4))));
//      case "Month": return retrieve(timeStapToLong(mask(s,start.substring(2))), timeStapToLong(mask(e,end.substring(2))));
//      case "Year": return retrieve(timeStapToLong(mask(s,start)), timeStapToLong(mask(e,end)));
//      default: return null;
//    }
//
//  }
//
//  private String mask(String timestamp, String mask) {
//    int j = timestamp.length() - 2;
//    for (int i = mask.length() - 2; i > -1; i -= 2) {
//      timestamp = timestamp.substring(0, j) + mask.substring(i, i + 2)
//          + (j + 2 < timestamp.length() ? timestamp.substring(j + 2) : "");
//      j -= 3;
//    }
//    return timestamp;
//  }
//
//  private long timeStapToLong(String timestamp) {
//    return Long.parseLong(timestamp.replaceAll(":", ""));
//  }
//
//  private List<Integer> retrieve(long start, long end) {
//    Set<Integer> set = new HashSet<>();
//    for (long key : map.keySet()) {
//      if (key >= start && key <= end) set.addAll(map.get(key));
//    }
//    return new ArrayList<>(set);
//  }
}
