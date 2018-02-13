package com.leet.algo;

/**
 * Created by ayanc on 2/12/18.
 */
public class Prob533 {
  public int findBlackPixel(char[][] picture, int N) {
    int x, y;
    if (picture == null || (x = picture.length) < 1 || (y = picture[0].length) < 1) return 0;
    int[] colCount = new int[y];
    int[] rowCount = new int[x];
    String[] words = new String[x];
    for (int i = 0; i < x; i++) {
      String word = "";
      for (int j = 0; j < y; j++) {
        word += picture[i][j];
        if (picture[i][j] == 'B') {
          colCount[j]++;
          rowCount[i]++;
        }
      }
      words[i] = word;
    }
    int result = 0;
    for (int i = 0; i < x; i++) {
      for (int j = 0; j < y; j++) {
        if (picture[i][j] == 'B' && rowCount[i] == colCount[j] && rowCount[i] == N) {
          boolean increment = true;
          String word = words[i];
          for (int k = 0; k < x; k++) {
            if (k == i || picture[k][j] != 'B') continue;
            if (!word.equals(words[k])) {
              increment = false;
              break;
            }
          }
          if (increment) result++;
        }
      }
    }
    return result;
  }
}
