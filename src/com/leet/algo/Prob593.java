package com.leet.algo;

/**
 * Created by ayanc on 1/10/18.
 */
public class Prob593 {
  public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
    int p1p2 = distance(p1, p2);
    int p1p3 = distance(p1, p3);
    int p1p4 = distance(p1, p4);
    if(p1p2 == 0 || p1p3 == 0 || p1p4 == 0) return false;
    int[] first = p1;
    int[] third = null;
    int[] second = null;
    int[] fourth = null;
    int side = 0;
    if(p1p2 == p1p3 && p1p2 == p1p4) return false;
    if(p1p2 == p1p3){
      side = p1p2;
      third = p4;
      second = p2;
      fourth = p3;
    } else if(p1p2 == p1p4){
      side = p1p2;
      third = p3;
      second = p2;
      fourth = p4;
    } else if(p1p3 == p1p4){
      side = p1p3;
      third = p2;
      second = p3;
      fourth = p4;
    } else return false;

    int dis23 = distance(second, third);
    int dis34 = distance(third, fourth);
    if(dis23 != dis34) return false;
    int dia1 = distance(second, fourth);
    int dia2 = distance(first, third);
    if(dia1 != 2 * side || dia2 != 2 * side) return false;
    return true;
  }

  private int distance(int[] p1, int[] p2){
    return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
  }

  public static void
  main(String[] args){
    Prob593 prob593 = new Prob593();
    System.out.println(prob593.validSquare(new int[]{0, 0}, new int[]{1, 1}, new int[]{1, 0}, new int[]{0, 1}));
  }
}
