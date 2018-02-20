package com.leet.algo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ayanc on 2/20/18.
 */
public class Prob158 {
  private boolean eof;
  private List<Character> list = new ArrayList<>();
  int lastRead = -1;
  public int read(char[] buf, int n) {
    if (n == 0) return 0;
    int w = 0;
    while (lastRead < list.size() - 1 && w < n) {
      buf[w++] = list.get(++lastRead);
    }
    if (w == n) return w;
    if (eof) {
      return w;
    }
    char[] temp = new char[4];
    while (!eof && list.size() - lastRead - 1 < n - w) {
      int r = read4(temp);
      if (r < 4) eof = true;
      for (int i = 0; i < r; i++) {
        list.add(temp[i]);
      }
    }
    while (lastRead < list.size() - 1 && w < n) {
      buf[w++] = list.get(++lastRead);
    }
    return w;
  }

  //dummy
  private int read4(char[] buf) {
    return 0;
  }
}
