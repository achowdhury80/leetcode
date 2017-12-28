package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob29 {
  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> result = new ArrayList<>();
    if(strs == null || strs.length == 0) return result;
    Map<String, List<String>> map = new HashMap<>();
    for(String str : strs){
      String compressedKey = findCompressedKey(str);
      if(map.containsKey(compressedKey)){
        map.get(compressedKey).add(str);
      } else {
        List<String> list = new ArrayList<>();
        list.add(str);
        map.put(compressedKey, list);
      }
    }
    System.out.println(map);
    map.keySet().stream().forEach(key -> result.add(map.get(key)));
    return result;
  }

  private String findCompressedKey(String str){
    if(str == null || str == "") return "";
    int[] charFreq = new int[26];
    IntStream.range(0, str.length()).forEach(idx -> {
      charFreq[str.charAt(idx) - 'a']++;
    });
    StringBuilder sb = new StringBuilder();
    IntStream.range(0, 26).forEach(idx -> {
      if(charFreq[idx] > 0){
        sb.append(((char)('a' + idx)) + "" + charFreq[idx]);
      }
    });
    return sb.toString();
  }

  public static void main(String[] args){
    Prob29 prob29 = new Prob29();
    System.out.println(prob29.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
  }
}
