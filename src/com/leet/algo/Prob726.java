package com.leet.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by ayanc on 12/7/17.
 */
public class Prob726 {
  public String countOfAtoms(String formula) {
    String result = "";
    if(formula == null || formula.length() == 0) return result;
    Stack<AtomCount> stack = new Stack<>();
    for(int i = 0; i < formula.length(); i++){
      if(formula.charAt(i) == '('){
        stack.push(new AtomCount("(", 1));
      } else if (formula.charAt(i) == ')'){
        String number = "";
        while(i < formula.length() - 1){
          char c = formula.charAt(i + 1);
          if(isNumber(c)){
            number += c;
            i++;
          } else break;
        }
        int count = Integer.parseInt(number);
        List<AtomCount> list = new ArrayList<>();
        AtomCount atomCount = stack.pop();
        while(!atomCount.name.equals("(")){
          atomCount.count = count * atomCount.count;
          list.add(atomCount);
          atomCount = stack.pop();
        }
        list.stream().forEach(x -> stack.push(x));
      } else {
        String element = "" + formula.charAt(i);
        String count = "";
        while(i < formula.length() - 1){
          char c = formula.charAt(i + 1);
          if(isUpperCaseLetter(c)) break;
          if(isLowerCaseLetter(c)) {
            element += c;
            i++;
          } else if(isNumber(c)){
            count += c;
            i++;
          } else {
            break;
          }
        }

        stack.push(new AtomCount(element, count.equals("") ? 1 : Integer.parseInt(count)));
      }
    }

    Map<String, Integer> map = new HashMap<>();
    while (!stack.empty()){
      AtomCount atomCount = stack.pop();
      if(map.containsKey(atomCount.name)){
        map.put(atomCount.name, atomCount.count + map.get(atomCount.name));
      } else {
        map.put(atomCount.name, atomCount.count);
      }
    }

    List<String> elements = new ArrayList<>(map.keySet());
    Collections.sort(elements);
    for(String element : elements){
      int count = map.get(element);
      result += element + (count == 1 ? "" : count);
    }

    return result;
  }
  class AtomCount {
    String name;
    int count;

    AtomCount(String name, int count){
      this.name = name;
      this.count = count;
    }
  }

  private boolean isNumber(char c){
    return c >= '0' && c <= '9';
  }

  private boolean isUpperCaseLetter(char c){
    return c >= 'A' && c <= 'Z';
  }

  private boolean isLowerCaseLetter(char c){
    return c >= 'a' && c <= 'z';
  }

  public static void main(String[] args){
    Prob726 prob726 = new Prob726();
    System.out.println(prob726.countOfAtoms("H2O"));
    System.out.println(prob726.countOfAtoms("Mg(OH)2"));
    System.out.println(prob726.countOfAtoms("K4(ON(SO3)2)2"));
  }
}
