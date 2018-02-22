package com.leet.algo;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ayanc on 2/19/18.
 */
public class Prob85 {
  public int maximalRectangle(char[][] matrix) {
    int m, n;
    if (matrix == null || (m = matrix.length) < 1 || (n = matrix[0].length) < 1) return 0;
    int[] heights = new int[n];
    int result = 0;
    Stack<Integer> stack = new Stack<>();
    for (int i = 0; i < m; i++) {
      int j = 0;
      stack.clear();
      for (int k = 0; k < n; k++) heights[k] = matrix[i][k] == '1' ? heights[k] + 1 : 0;
      while (j <= n) {
        int cur = 0;
        if (j < n) {
          cur = heights[j];
        }
        if (stack.isEmpty() || cur >= heights[stack.peek()]) stack.push(j++);
        else {
          int tp = stack.pop();
          result = Math.max(result, heights[tp] * (stack.isEmpty() ? j : j - stack.peek() - 1));
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Prob85 prob85 = new Prob85();
    System.out.println(prob85.maximalRectangle(new char[][]{
        {'1','0','1','0','0'},
        {'1','0','1','1','1'},
        {'1','1','1','1','1'},
        {'1','0','0','1','0'}
    }));
  }
}
