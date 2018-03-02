package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by ayanc on 3/1/18.
 */
public class Prob305 {
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> result = new ArrayList<>();
    if (positions == null || positions.length < 1) return result;
    int[] parent = new int[m * n];
    Arrays.fill(parent, -1);
    int[] size = new int[m * n];
    int sum = 0;
    for (int[] position : positions) {
      sum = addLand(parent, size, position, sum, m, n);
      result.add(sum);
    }
    return result;
  }

  //0 based
  private int findIndex(int[] position, int colSize) {
    return position[0] * colSize + position[1];
  }

  private int findParent(int[] parent, int index) {
    if (parent[index] == -1) return -1;
    while (parent[index] != index) index = parent[index];
    return index;
  }

  private void union(int[] parent, int[] size, int index1, int index2) {
    int parent1 = findParent(parent, index1);
    int parent2 = findParent(parent, index2);
    if (parent1 == parent2) return;
    if (size[parent1] >= size[parent2]) {
      parent[parent2] = parent1;
      size[parent1] += size[parent2];
    } else {
      parent[parent1] = parent2;
      size[parent2] += size[parent1];
    }

  }

  private int addLand(int[] parent, int[] size, int[] position, int previousSum, int rowSize, int colSize) {
    int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    int index = findIndex(position, colSize);
    int p = findParent(parent, index);
    if (p == -1) {
      parent[index] = index;
      size[index] = 1;
      int x, y;
      Set<Integer> parentSet = new HashSet<>();
      for (int[] dir : dirs) {
        x = position[0] + dir[0];
        y = position[1] + dir[1];
        if (x > - 1 && x < rowSize && y > -1 && y < colSize) {
          int xyIndex = findIndex(new int[]{x, y}, colSize);
          int xyParent = findParent(parent, xyIndex);
          if (xyParent != -1) {
            parentSet.add(xyParent);
          }
        }
      }
      if (parentSet.size() == 0) return previousSum + 1;
      for (int parentIndex : parentSet) {
        union(parent, size, index, parentIndex);
      }
      return previousSum + 1 - parentSet.size();
    } else return previousSum;
  }

  public static void main(String[] args) {
    Prob305 prob305 = new Prob305();
    System.out.println(prob305.numIslands2(3, 3, new int[][]{{0,0}, {0,1}, {1, 2}, {2, 1}}));
  }
}
