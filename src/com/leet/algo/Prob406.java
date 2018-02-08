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
    Arrays.sort(people, (int[]x, int[]y) -> {
      if (y[0] == x[0]) return x[1] - y[1];
      return y[0] - x[0];
    });
    List<int[]> list = new ArrayList<>();
    for (int i = 0; i < people.length; i++) {
//      if (list.isEmpty() || people[i][1] > list.size()) list.add(people[i]);
//      else
      list.add(people[i][1], people[i]);
    }
    IntStream.range(0, list.size()).forEach(id -> people[id] = list.get(id));
    return people;
  }

  public static void main(String[] args){
    Prob406 prob406 = new Prob406();
//    int[][] result = prob406.reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
    int[][] result = prob406.reconstructQueue(new int[][]{{9,0},{7,0},{1,9},{3,0},{2,7},{5,3},{6,0},{3,4},{6,2},{5,2}});
    Arrays.stream(result).forEach(x -> System.out.print("(" + x[0] + ", " + x[1] + "), "));
  }
}
