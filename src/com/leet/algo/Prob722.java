package com.leet.algo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by ayanc on 12/29/17.
 */
public class Prob722 {
  public List<String> removeComments(String[] source) {
    List<String> result = new ArrayList<>();
    if(source == null || source.length == 0) return result;
    boolean blockCommentStart = false;
    boolean singleLineCommentStart = false;
    for(String st : source){
      Map<String, List<Integer>> locationMap = findIndices(st);
      if(!blockCommentStart){
        if(locationMap.get("//").size() > 0){
          if(locationMap.get("/*").size() < 1){
            st = st.substring(locationMap.get("//").get(0));
          } else {
            if(locationMap.get("//").get(0) > locationMap.get("/*").get(0)){
              st = st.substring(locationMap.get("//").get(0));
            } else {

            }
          }
        }
      } else {

      }
    }
    return null;
  }

  private Map<String, List<Integer>> findIndices(String st){
    Map<String, List<Integer>> map = new HashMap<>();

    map.put("//", new ArrayList<>());
    map.put("/*", new ArrayList<>());
    map.put("*/", new ArrayList<>());
    int start = 0;
    String temp = st;
    int i;
    while(temp.length() > 1 &&(i = temp.indexOf("//")) > -1){
      map.get("//").add(i);
      temp = temp.substring(i + 2);
    }
    temp = st;
    while(temp.length() > 1 && (i = temp.indexOf("/*")) > -1){
      map.get("/*").add(i);
      temp = temp.substring(i + 2);
    }
    temp = st;
    while(temp.length() > 1 && (i = temp.indexOf("*/")) > -1){
      if(temp.indexOf("/*/") == i) {
        temp = temp.substring(i + 3);
        continue;
      }
      map.get("*/").add(i);
      temp = temp.substring(i + 2);
    }
    return map;
  }

  public static void main(String[] args){
    String st = "helo / is  // this is a comment";
    System.out.println(st.indexOf("//"));

    String s = "hello//";
    s = s.substring(s.indexOf("//") + 2);
    System.out.println(s);
  }
}
