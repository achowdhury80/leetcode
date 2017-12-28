package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by ayanc on 11/14/17.
 */
public class Prob406 {
  public int[][] reconstructQueue(int[][] people) {
    if(people == null || people.length < 2) return people;
    Object[] objects = Arrays.stream(people).map(x -> new Integer[]{x[0], x[1]}).sorted((a, b) -> {
      if(a[0] == b[0]){
        return Integer.valueOf(a[1]).compareTo(b[1]);
      }
      return Integer.valueOf(b[0]).compareTo(a[0]);
    }).toArray();
    List<Integer[]> list = new ArrayList<>();
    for(Object obj : objects){
      Integer[] intArr = (Integer[]) obj;
      list.add(intArr[1], intArr);
    }
    int[][] result = new int[people.length][2];
    IntStream.range(0, list.size()).forEach(idx -> result[idx] = new int[]{list.get(idx)[0], list.get(idx)[1]});
    return result;
  }

  public static void main(String[] args){
    Prob406 prob406 = new Prob406();
    int[][] result = prob406.reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
    Arrays.stream(result).forEach(x -> System.out.print("(" + x[0] + ", " + x[1] + "), "));
  }
}
