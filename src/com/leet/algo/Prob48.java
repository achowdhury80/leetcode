package com.leet.algo;

/**
 * Created by ayanc on 1/21/18.
 */
public class Prob48 {
  public void rotate(int[][] matrix) {
    int n;
    if(matrix == null || (n = matrix.length) < 2) return;
    int width = n;
    int r = 0;
    int c = 0;

    while(width > 1){
      int[] firstLoc = new int[]{r, c};
      int[] secondLoc = new int[]{r, c + width -1};
      int[] thirdLoc = new int[]{r + width - 1, c + width -1};
      int[] fourthLoc = new int[]{r + width - 1, c};
      for(int i = 0; i < width - 1; i++){
        int temp = matrix[firstLoc[0]][firstLoc[1]];
        matrix[firstLoc[0]][firstLoc[1]] = matrix[fourthLoc[0]][fourthLoc[1]];
        matrix[fourthLoc[0]][fourthLoc[1]] = matrix[thirdLoc[0]][thirdLoc[1]];
        matrix[thirdLoc[0]][thirdLoc[1]] = matrix[secondLoc[0]][secondLoc[1]];
        matrix[secondLoc[0]][secondLoc[1]] = temp;
        firstLoc[1] = firstLoc[1] + 1;
        secondLoc[0] = secondLoc[0] + 1;
        thirdLoc[1] = thirdLoc[1] - 1;
        fourthLoc[0] = fourthLoc[0] - 1;
      }
      width -= 2;
      r++;
      c++;
    }

  }
}
