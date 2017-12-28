package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob609 {
  public List<List<String>> findDuplicate(String[] paths) {
    List<List<String>> result = new ArrayList<>();
    if(paths == null || paths.length == 0) return result;
    Map<String, List<String>> map = new HashMap<>();
    Set<String> set = new HashSet<String>();
    Arrays.stream(paths).forEach(path -> {
      String[] strs = path.split(" ");
      String prefix = "root";
      int start = 0;
      if(!strs[0].contains("(")){
        prefix = strs[0];
        start = 1;
      }
      for(int i = start; i < strs.length; i++){
        String fileName = strs[i].substring(0, strs[i].indexOf("("));
        String content = strs[i].substring(strs[i].indexOf("(") + 1, strs[i].length() - 1);
        if(map.containsKey(content)){
          map.get(content).add(prefix + "/" + fileName);
          set.add(content);
        } else {
          List<String> list = new ArrayList<String>();
          list.add(prefix + "/" + fileName);
          map.put(content, list);
        }
      }
    });
    set.stream().forEach(content -> result.add(map.get(content)));
    return result;
  }

  public static void main(String[] args){
    Prob609 prob609 = new Prob609();
    System.out.println(prob609.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)","root/c 3.txt(abcd)","root/c/d 4.txt(efgh)","root 4.txt(efgh)"}));
  }
}
