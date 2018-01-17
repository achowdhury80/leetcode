package com.leet.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayanc on 11/6/17.
 */
public class Prob207 {
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    if(numCourses < 2 || prerequisites == null || prerequisites.length < 1) return true;
    int[] indegrees = new int[numCourses];
    for(int[] pair : prerequisites){
      indegrees[pair[0]]++;
    }

    Queue<Integer> q = new LinkedList<>();
    for(int i = 0; i < indegrees.length; i++){
      if(indegrees[i] == 0) q.offer(i);
    }

    while(!q.isEmpty()){
      numCourses--;
      int course = q.poll();
      for(int[] pair : prerequisites){
        if(pair[1] == course){
          indegrees[pair[0]]--;
          if(indegrees[pair[0]] == 0) q.offer(pair[0]);
        }
      }
    }
    return numCourses == 0;
  }

  public static void main(String[] args){
    Prob207 prob207 = new Prob207();
    System.out.println(prob207.canFinish(2, new int[][]{{1, 0}}));
    System.out.println(prob207.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
  }
}
