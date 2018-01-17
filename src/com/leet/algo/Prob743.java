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
 * Created by ayanc on 1/15/18.
 */
public class Prob743 {
  public int networkDelayTime(int[][] times, int N, int K) {
    Map<Integer, List<int[]>> map = new HashMap<>();
    Arrays.stream(times).forEach(intArr -> {
      List<int[]> list;
      if(map.containsKey(intArr[0])){
        list = map.get(intArr[0]);
      } else list = new ArrayList<int[]>();
      list.add(new int[]{intArr[1], intArr[2]});
      map.put(intArr[0], list);
    });
    int[] time = new int[N + 1];
    Queue<Integer> q = new LinkedList<>();
    q.add(K);
    Set<Integer> explored = new HashSet<>();
    while(!q.isEmpty()){
      int node = q.poll();
      if(explored.contains(node)) continue;
      explored.add(node);
      if(map.containsKey(node)){
        for(int[] ints : map.get(node)){
          int nextNode = ints[0];
          if(nextNode == K) continue;
          int weight = ints[1];
          if(time[nextNode] == 0) time[nextNode] = time[node] + weight;
          else time[nextNode] = Math.min(time[node] + weight, time[nextNode]);
          q.add(nextNode);
        }
      }
    }
    int result = Integer.MIN_VALUE;
    for(int i = 1; i <= N; i++){
      if(i == K) continue;
      if(time[i] == 0) return -1;
      result = Math.max(result, time[i]);
    }
    return result;
  }

  public static void main(String[] args){
    Prob743 prob743 = new Prob743();
    //System.out.println(prob743.networkDelayTime(new int[][]{{2,1,1},{2,3,1},{3,4,1}}, 4, 2));
    System.out.println(prob743.networkDelayTime(new int[][]{{4,2,76},{1,3,79},{3,1,81},{4,3,30},{2,1,47},{1,5,61},
        {1,4,99},{3,4,68},{3,5,46},{4,1,6},{5,4,7},{5,3,44},{4,5,19},{2,3,13},{3,2,18},{1,2,0},{5,1,25},{2,5,58},
        {2,4,77},{5,2,74}}, 5, 3));
  }
}
