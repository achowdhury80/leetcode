package com.leet.algo;

/**
 * Created by ayanc on 2/11/18.
 */
public class Prob245 {
  public int shortestWordDistance(String[] words, String word1, String word2) {
    int word1Index = -1, word2Index = -1;
    int result = Integer.MAX_VALUE;
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      if (word.equals(word1)) {
        if (word1Index == - 1) word1Index = i;
        else {
          if(word1.equals(word2)) result = Math.min(result, Math.abs(i - word1Index));
          word1Index = i;
        }
        if(!word1.equals(word2) && word2Index != -1) result = Math.min(result, Math.abs(i - word2Index));
      } else if(word.equals(word2)) {
        word2Index = i;
        if(word1Index != -1) result = Math.min(result, Math.abs(i - word1Index));
      }
    }
    return result;
  }

  public static void main(String[] args) {
    Prob245 prob245 = new Prob245();
    System.out.println(prob245.shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "coding"));
    System.out.println(prob245.shortestWordDistance(new String[]{"practice", "makes", "perfect", "coding", "makes"}, "makes", "makes"));
  }
}
/**
 * Shortest Word Distance III
 DescriptionHintsSubmissionsDiscussSolution
 Pick One
 This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.

 Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.

 word1 and word2 may be the same and they represent two individual words in the list.

 For example,
 Assume that words = ["practice", "makes", "perfect", "coding", "makes"].

 Given word1 = “makes”, word2 = “coding”, return 1.
 Given word1 = "makes", word2 = "makes", return 3.

 Note:
 You may assume word1 and word2 are both in the list.
 */
