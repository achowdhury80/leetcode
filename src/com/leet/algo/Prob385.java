package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 1/19/18.
 */
public class Prob385 {
  public NestedInteger deserialize(String s) {
    if(!s.startsWith("[")) {
      return new NestedInteger(Integer.parseInt(s));
    }
    int listStartCount = 0;
    String nextElement = "";
    NestedInteger nestedInteger = new NestedInteger();
    List<NestedInteger> list = new ArrayList<>();
    for (int i = 1; i < s.length() - 1; i++) {
      char c = s.charAt(i);
      if(listStartCount > 0) {
        nextElement += c;
        if (c == '[') listStartCount++;
        else if (c == ']') listStartCount--;
      } else {
        if (c == '[') {
          listStartCount++;
          nextElement += c;
        }
        else if (c == ',') {
          nestedInteger.add(deserialize(nextElement));
          nextElement = "";
        } else {
          nextElement += c;
        }
      }
    }
    if(!nextElement.equals("")) nestedInteger.add(deserialize(nextElement));
    return nestedInteger;
  }

  public static void main(String[] args) {
    Prob385 prob385 = new Prob385();
//    NestedInteger nestedInteger = prob385.deserialize("324");
//    NestedInteger nestedInteger = prob385.deserialize("[123,[456,[789]]]");
    NestedInteger nestedInteger = prob385.deserialize("[]");
    System.out.println(nestedInteger);
  }
}
