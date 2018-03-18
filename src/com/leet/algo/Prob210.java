package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Created by ayanc on 1/16/18.
 */
public class Prob210 {

  public int[] findOrder(int numCourses, int[][] prerequisites) {
    if(numCourses <= 0) return new int[0];
    if(numCourses == 1){
      int[] result = new int[1];
      result[0] = 0;
    }
    int[] result = new int[numCourses];
    if(prerequisites == null || prerequisites.length < 1) {
      for(int i = 0; i < result.length; i++){
        result[i] = i;
      }
      return result;
    }
    Map<Integer, Integer> indegree = new HashMap<>();
    Map<Integer, Set<Integer>> map = new HashMap<>();
    for (int i = 0; i < numCourses; i++) indegree.put(i, 0);
    for (int[] pair : prerequisites) {
      indegree.put(pair[0], indegree.getOrDefault(pair[0], 0) + 1);
      if (!map.containsKey(pair[1])) map.put(pair[1], new HashSet<>());
      map.get(pair[1]).add(pair[0]);
    }
    Queue<Integer> q = new LinkedList<>();
    for (int key : indegree.keySet()) {
      if (indegree.get(key) == 0) q.add(key);
    }
    int i = 0;
    while (!q.isEmpty()) {
      int c = q.poll();
      result[i++] = c;
      if (map.containsKey(c)) {
        for (int key : map.get(c)) {
          indegree.put(key, indegree.get(key) - 1);
          if (indegree.get(key) == 0) q.add(key);
        }
      }
    }
    return i == result.length ? result : new int[0];
  }
  public int[] findOrder1(int numCourses, int[][] prerequisites) {
    if(numCourses <= 0) return new int[0];
    if(numCourses == 1){
      int[] result = new int[1];
      result[0] = 0;
    }
    if(prerequisites == null || prerequisites.length < 1) {
      int[] result = new int[numCourses];
      for(int i = 0; i < result.length; i++){
        result[i] = i;
      }
      return result;
    }
    List<Integer> list = new ArrayList<>();
    int[] indegrees = new int[numCourses];
    for(int[] pair : prerequisites){
      indegrees[pair[0]]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < indegrees.length; i++){
      if(indegrees[i] == 0) q.offer(i);
    }

    while(!q.isEmpty()){
      int course = q.poll();
      list.add(course);
      for(int[] pair : prerequisites){
        if(pair[1] == course){
          indegrees[pair[0]]--;
          if(indegrees[pair[0]] == 0) q.offer(pair[0]);
        }
      }
    }
    if(list.size() < numCourses) return new int[0];
    return list.stream().mapToInt(x -> x).toArray();
  }

  public static void main(String[] args){
    Prob210 prob210 = new Prob210();
    int[] result = prob210.findOrder(2, new int[][]{{1, 0}});
    Arrays.stream(result).forEach(x -> System.out.print(x + ", "));
    System.out.println();
    result = prob210.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3,1}, {3, 2}});
    Arrays.stream(result).forEach(x -> System.out.print(x + ", "));
  }
}
