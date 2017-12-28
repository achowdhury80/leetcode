package com.leet.algo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 * Created by ayanc on 12/8/17.
 */
public class Prob720 {
  public String longestWord(String[] words) {
    if(words == null || words.length == 0) return "";
    TreeSet<String> sortedSet = new TreeSet<>(new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        int comparedValue = new Integer(s2.length()).compareTo(s1.length());
        if(comparedValue == 0){
          return s1.compareTo(s2);
        }
        return comparedValue;
      }
    });
    Arrays.stream(words).forEach(s -> sortedSet.add(s));
    while(!sortedSet.isEmpty()){
      String result = sortedSet.first();
      if(result.length() == 1) return result;
      String next = result.substring(0, result.length() - 1);
      while(sortedSet.contains(next) && next.length() > 1){
        sortedSet.remove(next);
        next = next.substring(0, next.length() - 1);
      }
      if(next.length() == 1 && sortedSet.contains(next)) return result;
      sortedSet.remove(result);
    }
    return "";
  }

  public static void main(String[] args){
    Prob720 prob720 = new Prob720();
    System.out.println(prob720.longestWord(new String[]{"w","wo","wor","worl", "world"}));
    System.out.println(prob720.longestWord(new String[]{"a", "banana", "app", "appl", "ap", "apply", "apple"}));

    System.out.println(prob720.longestWord(new String[]{"yo","ew","fc","zrc","yodn","fcm","qm","qmo","fcmz","z","ewq","yod","ewqz","y"}));
  }
}
