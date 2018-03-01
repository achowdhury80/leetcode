package com.leet.algo;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob604 {
  private Queue<int[]> q;

  public Prob604(String compressedString) {
    q = new LinkedList<>();
    if (compressedString == null || compressedString.equals("")) return;
    Character lastChar = null;
    for (int i = 0; i < compressedString.length(); i++) {
      if (compressedString.charAt(i) - 'A' >= 0) {
        lastChar = compressedString.charAt(i);
      } else {
        int j = i + 1;
        while (j < compressedString.length() && compressedString.charAt(j) - 'A' < 0){
          j++;
        }
        q.add(new int[]{lastChar, Integer.parseInt(compressedString.substring(i, j))});
        i = j -1;
      }
    }
  }

  public char next() {
    if (q.isEmpty()) return ' ';
    int[] ints = q.peek();
    char c = (char)ints[0];
    if (ints[1] == 1) {
      q.poll();
    }
    else ints[1]--;
    return c;
  }

  public boolean hasNext() {
    return !q.isEmpty();
  }

  public static void main(String[] args) {
    Prob604 prob604 = new Prob604("L1e2t1C1o1d1e1");
    System.out.println(prob604.next());
    System.out.println(prob604.next());
    System.out.println(prob604.next());
    System.out.println(prob604.next());
    System.out.println(prob604.next());
    System.out.println(prob604.next());
    System.out.println(prob604.hasNext());
    System.out.println(prob604.next());
    System.out.println(prob604.hasNext());
  }

}
