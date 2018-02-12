package com.leet.algo;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob573 {
  public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
    int result = 0;
    int maxDiff = Integer.MIN_VALUE;
    for (int i = 0; i < nuts.length; i++) {
      int distance = findDistance(tree, nuts[i]);
      result += 2 * distance;
      maxDiff = Math.max(maxDiff, distance - findDistance(nuts[i], squirrel));
    }
    return result - maxDiff;
  }

  private int findDistance(int[] x, int[] y){
    return Math.abs(x[0] - y[0]) + Math.abs(x[1] - y[1]);
  }

  public static void main(String[] args) {
    Prob573 prob573 = new Prob573();
    System.out.println(prob573.minDistance(5, 7, new int[]{2, 2}, new int[]{4, 4}, new int[][]{{3, 0}, {2, 5}}));
  }
}
/**
 *
 * Squirrel Simulation
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 There's a tree, a squirrel, and several nuts. Positions are represented by the cells in a 2D grid. Your goal is to find the minimal distance for the squirrel to collect all the nuts and put them under the tree one by one. The squirrel can only take at most one nut at one time and can move in four directions - up, down, left and right, to the adjacent cell. The distance is represented by the number of moves.
 Example 1:
 Input:
 Height : 5
 Width : 7
 Tree position : [2,2]
 Squirrel : [4,4]
 Nuts : [[3,0], [2,5]]
 Output: 12
 Explanation:

 Note:
 All given positions won't overlap.
 The squirrel can take at most one nut at one time.
 The given positions of nuts have no order.
 Height and width are positive integers. 3 <= height * width <= 10,000.
 The given positions contain at least one nut, only one tree and one squirrel.
 */