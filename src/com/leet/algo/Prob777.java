package com.leet.algo;

/**
 * Created by ayanc on 2/18/18.
 */
public class Prob777 {
  public boolean canTransform(String start, String end) {
    int i = 0, j = 0, n = Math.min(start.length(), end.length());
    while (i < n && j < n) {
      while (i < n && start.charAt(i) == 'X') i++;
      while (j < n && end.charAt(j) == 'X') j++;
      if (i == n && j == n) break;
      if (i == n || j == n || start.charAt(i) != end.charAt(j)) return false;
      if (start.charAt(i) == 'R' && i > j) return false;
      if (start.charAt(i) == 'L' && j > i) return false;
      i++;
      j++;
    }
    return true;
  }

  public static void main(String[] args) {
    Prob777 prob777 = new Prob777();
    System.out.println(prob777.canTransform("RXXLRXRXL", "XRLXXRRLX"));
    System.out.println(prob777.canTransform("XRXXLXLXXXXRXXXXLXXL", "XXRXLXXLXXRLXXXLXXXX"));

  }


}
