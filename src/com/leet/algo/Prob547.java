package com.leet.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ayanc on 11/16/17.
 */
public class Prob547 {
  public int findCircleNum(int[][] M) {
    int n;
    if(M == null || (n = M.length) == 0) return 0;
    int[] id = new int[n];
    int[] size = new int[n];
    for(int i = 0; i < n; i++) id[i] = -1;
    for(int i = 0; i < n; i ++){
      for(int j = 0; j < n; j++){
        if(M[i][j] == 1){
          union(id, size, i, j);
        }
      }
    }
    Set<Integer> set = new HashSet<>();
    for(int i = 0; i < n; i++){
      if(id[i] != -1) set.add(find(id, id[i]));
    }
    return set.size();
  }

  private void union(int[] id, int[] size, int i, int j){
    int rootI = find(id, i);
    int rootJ = find(id, j);
    if(rootI == -1 && rootJ == -1){
      id[i] = i;
      id[j] = i;
      size[i] = 1 + (i == j ? 0 : 1);
    } else if(rootI == -1){
      id[i] = rootJ;
      size[rootJ]++;
    } else if(rootJ == -1){
      id[j] = rootI;
      size[rootI]++;
    } else if(rootI != rootJ){
      if(size[rootI] > size[rootJ]){
        id[rootJ] = rootI;
        size[rootI] += size[rootJ];
      } else {
        id[rootI] = rootJ;
        size[rootJ] += size[rootI];
      }
    }
  }

  private int find(int[] id, int i){
    if(id[i] == -1) return -1;
    while(id[i] != i){
      i = id[i];
    }
    return id[i];
  }

  public static void main(String[] args){
    Prob547 prob547 = new Prob547();
    //System.out.println(prob547.findCircleNum(new int[][]{{1,1,0},{1,1,0},{0,0,1}}));
    System.out.println(prob547.findCircleNum(new int[][]{{1,0,0,1},{0,1,1,0},{0,1,1,1},{1,0,1,1}}));
  }


}
