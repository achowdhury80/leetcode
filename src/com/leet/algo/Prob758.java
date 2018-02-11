package com.leet.algo;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob758 {
  public String boldWords(String[] words, String S) {
    if(S == null || S.length() < 1 || words == null || words.length < 0) return S;
    boolean[] marked = new boolean[S.length()];
    mark(S, words, marked);
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < marked.length; i++) {
      if (marked[i] && (i == 0 || !marked[i - 1])) result.append("<b>");
      result.append(S.charAt(i));
      if (marked[i] && (i == S.length() - 1 || !marked[i + 1])) result.append("</b>");
    }
    return result.toString();
  }

  private void mark(String S, String[] words, boolean[] marked) {
    for (int i = 0; i < words.length; i++) {
      String word = words[i];
      for (int k = 0; k <= S.length() - word.length(); k++) {
        String subStr = S.substring(k, k + word.length());
        if (word.equals(subStr)) for (int j = 0; j < word.length(); j++) marked[k + j] = true;
      }
    }
  }
}
