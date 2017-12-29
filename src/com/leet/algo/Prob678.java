package com.leet.algo;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 12/28/17.
 */
public class Prob678 {
  public boolean checkValidString(String s) {
    if(s == null || s.trim().equals("")) return true;
    List<Integer> counts = new ArrayList<>();
    counts.add(0);
    for(int i = 0; i < s.length(); i++){
      if(s.charAt(i) == '(') counts = counts.stream().map(x -> x + 1).collect(Collectors.toList());
      else if(s.charAt(i) == ')'){
        counts = counts.stream().map(x -> x - 1).filter(x -> x > -1).collect(Collectors.toList());
        if(counts.isEmpty()) return false;
      } else {
        if(counts.isEmpty()){
          counts.add(0);
          counts.add(1);
        } else {
          Set<Integer> temp = new HashSet<>();
          for(Integer x : counts){
            temp.add(x);
            temp.add(x + 1);
            if(x > 0){
              temp.add(x - 1);
            }
            counts = new ArrayList<>(temp);
          }
        }
      }
    }
    if(counts.contains(0)) return true;
    return false;
  }

  public static void main(String[] args){
    Prob678 prob678 = new Prob678();
    System.out.println(prob678.checkValidString("()"));
    System.out.println(prob678.checkValidString("(*)"));
    System.out.println(prob678.checkValidString("(*))"));
    System.out.println(prob678.checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    //System.out.println(prob678.checkValidString("((*)(*()))(()"));
  }
}
