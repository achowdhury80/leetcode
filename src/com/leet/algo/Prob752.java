package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ayanc on 1/14/18.
 */
public class Prob752 {

  public int openLock(String[] deadends, String target) {
    if("0000".equals(target)) return 0;
    Set<String> deads = new HashSet(Arrays.asList(deadends));
    if(deads.contains("0000") || deads.contains(target)) return -1;
    Set<String> begin = new HashSet<>();
    begin.add("0000");
    Set<String> end = new HashSet<>();
    end.add(target);
    int level = 0;
    Set<String> temp;
    while(!begin.isEmpty() && !end.isEmpty()){
      if(begin.size() > end.size()){
        temp = begin;
        begin = end;
        end = temp;
      }
      temp = new HashSet<>();
      for(String s : begin){
        if(end.contains(s)) return level;
        if(deads.contains(s)) continue;
        deads.add(s);
        List<String> nextPositions = nextValidPositions(s, deads);
        for(int i = 0; i < nextPositions.size(); i++){
          temp.add(nextPositions.get(i));
        }
      }
      level++;
      begin = temp;
    }
    return -1;
  }

  public List<String> nextValidPositions(String startingPosition, Set<String> deadends){
    List<String> result = new ArrayList<>();
    //if(deadends.contains(startingPosition)) return result;
    for(int i = 0; i < startingPosition.length(); i++){
      String left = startingPosition.substring(0, i);
      String right = startingPosition.substring(i + 1);
      int num = Integer.parseInt("" + startingPosition.charAt(i));
      String st1 = left + (num + 1) % 10 + right;
      String st2 = left + (num + 9) % 10 + right;
      if(!deadends.contains(st1)) result.add(st1);
      if(!deadends.contains(st2)) result.add(st2);
    }
    return result;
  }

  public static void main(String[] args){
    Prob752 prob752 = new Prob752();
    System.out.println(prob752.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0202"));
    System.out.println(prob752.openLock(new String[]{"8888"}, "0009"));
    System.out.println(prob752.openLock(new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"}, "8888"));
    System.out.println(prob752.openLock(new String[]{"0000"}, "8888"));
    System.out.println(prob752.openLock(new String[]{"0201","0101","0102","1212","2002"}, "0001"));
  }
}
