package com.leet.algo;

/**
 * Created by ayanc on 2/16/18.
 */
public class Prob616 {
  public String addBoldTag(String s, String[] dict) {
    int n;
    if (s == null || (n = s.length()) < 1) return s;
    boolean[] bold = new boolean[n];
    for (int i = 0, end = 0; i < s.length(); i++) {
      for (String word : dict) {
        if (s.startsWith(word, i)) {
          end = Math.max(end, i + word.length());
        }
      }
      bold[i] = end > i;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < s.length(); i++) {
      if (!bold[i]) sb.append(s.charAt(i));
      else {
        int start = i;
        while (i < s.length() && bold[i]) i++;
        sb.append("<b>");
        sb.append(s.substring(start, i));
        sb.append("</b>");
        i--;
      }
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    Prob616 prob616 = new Prob616();
    System.out.println(prob616.addBoldTag("abcxyz123", new String[]{"abc","123"}));
    System.out.println(prob616.addBoldTag("aaabbcc", new String[]{"aaa","aab","bc"}));
  }
}
