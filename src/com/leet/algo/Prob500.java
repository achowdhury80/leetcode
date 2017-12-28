package com.leet.algo;

import java.util.stream.Stream;

/**
 * Created by ayanc on 11/13/17.
 */
public class Prob500 {
  public String[] findWords(String[] words) {
    if(words == null || words.length == 0) return null;
    return Stream.of(words).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
  }
}
