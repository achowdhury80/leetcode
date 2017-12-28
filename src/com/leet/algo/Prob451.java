package com.leet.algo;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by ayanc on 11/15/17.
 */
public class Prob451 {
  public String frequencySort(String s) {
    if(s == null || s.length() == 0) return s;
    Map<Character, String> map = new HashMap<>();

    for(int i = 0; i < s.length(); i++){
      if(map.get(s.charAt(i)) != null){
        map.put(s.charAt(i), map.get(s.charAt(i)) + s.charAt(i));
      }else {
        map.put(s.charAt(i), "" + s.charAt(i));
      }
    }

    ValueComparator bvc = new ValueComparator(map);

    TreeMap<Character, String> result = new TreeMap<Character, String>(bvc);
    result.putAll(map);
    String ans = "";
    for(Map.Entry<Character, String> entry : result.entrySet()){
      ans += entry.getValue();
    }
    return ans;

  }

  class ValueComparator implements Comparator<Character>{

    Map<Character, String> map = new HashMap<Character, String>();

    public ValueComparator(Map<Character, String> map){
      this.map.putAll(map);
    }

    @Override
    public int compare(Character s1, Character s2) {
      if(map.get(s1).length() >= map.get(s2).length()){
        return -1;
      }else{
        return 1;
      }
    }
  }
}
