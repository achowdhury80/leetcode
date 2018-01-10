package com.leet.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ayanc on 1/8/18.
 */
public class Prob200 {
  public int numIslands(char[][] grid) {
    if(grid == null || grid.length == 0) return 0;
    int m = grid.length, n = grid[0].length;
    Map<Integer, Integer> map = new HashMap<>();
    Map<Integer, Integer> sizeMap = new HashMap<>();
    for(int i = 0; i < m; i++){
      for(int j = 0; j < n; j++){
        if(grid[i][j] == '1') {
          map.put(i * n + j, n * i + j);
          sizeMap.put(n * i + j, 1);
        }
      }
    }
    for(int key : map.keySet()){
      int rowIndex = key / n;
      int colIndex = key % n;
      if(rowIndex > 0){
        if(grid[rowIndex - 1][colIndex] == '1'){
          connect(map, sizeMap, key, n * (rowIndex - 1) + colIndex);
        }
      }
      if(colIndex > 0){
        if(grid[rowIndex][colIndex - 1] == '1'){
          connect(map, sizeMap, key, n * rowIndex + colIndex - 1);
        }
      }
      if(rowIndex < m - 1){
        if(grid[rowIndex + 1][colIndex] == '1'){
          connect(map, sizeMap, key, n * (rowIndex + 1) + colIndex);
        }
      }
      if(colIndex < n - 1){
        //System.out.println("key: " + key);
        //System.out.println("rowIndex: " + rowIndex + ", colIndex + 1: " + (colIndex + 1));
        if(grid[rowIndex][colIndex + 1] == '1'){
          connect(map, sizeMap, key, n * rowIndex + colIndex + 1);
        }
      }
    }

    return sizeMap.size();
  }


  private int find(Map<Integer, Integer> map, int index){
    return map.get(index) == index ? index : find(map, map.get(index));
  }

  private void connect(Map<Integer, Integer> map, Map<Integer, Integer> sizeMap, int index1, int index2){
    int parent1 = find(map, index1);
    int parent2 = find(map, index2);
    if(parent1 != parent2){
      if(sizeMap.get(parent1) > sizeMap.get(parent2)){
        map.put(parent2, parent1);
        sizeMap.put(parent1, sizeMap.get(parent1) + sizeMap.get(parent2));
        sizeMap.remove(parent2);
      } else {
        map.put(parent1, parent2);
        sizeMap.put(parent2, sizeMap.get(parent1) + sizeMap.get(parent2));
        sizeMap.remove(parent1);
      }
    }
  }


  public static void main(String[] args){
    Prob200 prob200 = new Prob200();
    System.out.println(prob200.numIslands(new char[][]{{'1','1','0','0','0'},{'1','1','0','0','0'},{'0','0','1','0','0'},{'0','0','0','1','1'}}));
  }
}
