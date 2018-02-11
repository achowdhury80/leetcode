package com.leet.algo;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob243 {
  public int shortestDistance(String[] words, String word1, String word2) {
    int word1Index = -1;
    int word2Index = -1;
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (word.equals(word1) || word.equals(word2)) {
        if(word.equals(word1)) word1Index = i;
        else word2Index = i;
        if (word1Index != -1 && word2Index != -1) result = Math.min(result, Math.abs(word1Index - word2Index));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Prob243 prob243 = new Prob243();
    System.out.println(prob243.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "practice"));
    System.out.println(prob243.shortestDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "coding", "makes"));
  }
}
