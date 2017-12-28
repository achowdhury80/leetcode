package com.leet.algo;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by ayanc on 10/20/17.
 */
public class Prob447 {
  public int numberOfBoomerangs(int[][] points) {
    if(points == null || points.length < 3) return 0;
    double[][] distances = new double[points.length][points.length];
    for(int i = 0; i < points.length; i++){
      for( int j = 0; j < points.length; j++){
        int xDif = points[i][0] - points[j][0];
          int yDif = points[i][1] - points[j][1];
          distances[i][j] = Math.sqrt(xDif * xDif + yDif * yDif);
          distances[j][i] = distances[i][j];
      }
    }
    for(int i = 0; i < distances.length; i++){
      for(int j = 0; j < distances.length; j++){
        System.out.print(distances[i][j] + " ");
      }
      System.out.println();
    }
    int result = 0;
    for(int i = 0; i < distances.length; i++){
      Set<Double> set = new HashSet<>();
      for(int j = 0; j < points.length; j++){
        if(set.contains(distances[i][j])) result += 2;
        else set.add(distances[i][j]);
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob447 prob447 = new Prob447();
    int[][] points = new int[5][2];
    points[0][0] = 0;
    points[0][1] = 0;
    points[1][0] = 1;
    points[1][1] = 0;
    points[2][0] = -1;
    points[2][1] = 0;
    points[3][0] = 0;
    points[3][1] = 1;
    points[4][0] = 0;
    points[4][1] = -1;

    System.out.println(prob447.numberOfBoomerangs(points));
  }
}
