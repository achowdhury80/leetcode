package com.leet.algo;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob531 {
  public int findLonelyPixel(char[][] picture) {
    int m, n;
    if(picture == null || (m = picture.length) < 1 || (n = picture[0].length) < 1) return 0;
    char firstRow = picture[0][0];
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (picture[i][j] == 'B') {
          if (picture[0][j] != 'D' && picture[0][j] != 'Y') picture[0][j]++;
          if (i != 0) {
            if (picture[i][0] != 'D' && picture[i][0] != 'Y') picture[i][0]++;
          } else {
            if (picture[i][0] != 'D' && picture[i][0] != 'Y') firstRow++;
          }

        }
      }
    }
    int result = 0;
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        if (i != 0) {
          if (picture[i][j] == 'C' || picture[i][j] == 'B') {
            if ((picture[0][j] == 'C' || picture[0][j] == 'X') && (picture[i][0] == 'C' || picture[i][0] == 'X')) result++;
          }
        } else {
          if (picture[i][j] == 'C' || picture[i][j] == 'B') {
            if ((picture[0][j] == 'C' || picture[0][j] == 'X') && (firstRow == 'C' || firstRow == 'X')) result++;
          }
        }
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Prob531 prob531 = new Prob531();
    System.out.println(prob531.findLonelyPixel(new char[][]{{'W', 'W', 'B'},
        {'W', 'B', 'W'},
        {'B', 'W', 'W'}}));
  }
}

/**
 * Given a picture consisting of black and white pixels, find the number of black lonely pixels.

 The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

 A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

 Example:
 Input:
 [['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

 Output: 3
 Explanation: All the three 'B's are black lonely pixels.
 Note:
 The range of width and height of the input 2D array is [1,500].

 */