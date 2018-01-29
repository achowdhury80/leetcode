package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 1/28/18.
 */
public class Prob535 {
  private Map<String, List<String>> map = new HashMap<>();
  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
    int hash = longUrl.hashCode();
    String hex = Integer.toHexString(hash);
    if(map.containsKey(hex)){
      List<String> list = map.get(hex);
      for(int i = 0; i < list.size(); i++){
        if(map.get(i).equals(longUrl)) return hex + "#" + Integer.toHexString(i);
      }
    } else {
      map.put(hex, new ArrayList<>());
    }
    map.get(hex).add(longUrl);
    return "http://tinyurl.com/" + hex + "#" + Integer.toHexString(map.get(hex).size() - 1);
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
    String[] strings = shortUrl.substring(19).split("#");
    return map.get(strings[0]).get((int)Long.parseLong(strings[1], 16));
  }

  public static void main(String[] args){
    Prob535 prob535 = new Prob535();
    System.out.println(prob535.encode("https://leetcode.com/problems/design-tinyurl"));
    System.out.println(prob535.decode("http://tinyurl.com/baa3af43#0"));
    //System.out.println((int)Long.parseLong("baa3af43", 16));
  }
}
