package com.leet.algo;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob604 {
  private String compressedString;
  private char currentChar = ' ';
  private int currentCount = -1;
  private int nextIndex = -1;

  public Prob604(String compressedString) {
    this.compressedString = compressedString;
    int[] nextChar = find(compressedString, 0);
    currentChar = (char)nextChar[0];
    currentCount = nextChar[1];
    nextIndex = nextChar[2];
  }

  public char next() {
    if (currentCount == 0) return ' ';
    if (currentCount > 1) {
      currentCount--;
      return currentChar;
    }
    char c = currentChar;
    currentCount--;
    if (nextIndex != -1) {
      int[] nextChar = find(compressedString, nextIndex);
      currentChar = (char) nextChar[0];
      currentCount = nextChar[1];
      nextIndex = nextChar[2];
    }
    return c;
  }

  public boolean hasNext() {
    return currentCount != 0;
  }

  private int[] find(String compressedString, int nextIndex){
    int[] result = new int[3];
    result[0] = compressedString.charAt(nextIndex);
    String countStr = "";
    int i = nextIndex + 1;
    for (; i < compressedString.length() && Character.isDigit(compressedString.charAt(i)); i++) {
      countStr = countStr + compressedString.charAt(i);
    }
    result[1] = Integer.parseInt(countStr);
    result[2] = (i == compressedString.length()) ? -1 : i;
    return result;
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
