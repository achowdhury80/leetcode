package com.leet.algo;

/**
 * Created by ayanc on 2/10/18.
 */
public class Prob408 {
  public boolean validWordAbbreviation(String word, String abbr) {
    if (word == null || word.length() < 1 || abbr == null || abbr.length() < 1) return false;
    int wordStart = 0;
    int abbrStart = 0;

    while (wordStart < word.length() && abbrStart < abbr.length()) {
      char c = abbr.charAt(abbrStart++);
      if (c >= 'a' && c <= 'z') {
        if (c != word.charAt(wordStart++)) return false;
      } else {
        if (c == '0') return false;
        String numStr = "" + c;
        while(abbrStart < abbr.length() && Character.isDigit(abbr.charAt(abbrStart))) {
          numStr = numStr + abbr.charAt(abbrStart);
          abbrStart++;
        }
        int count = Integer.parseInt(numStr);
        if (wordStart + count > word.length()) return false;
        wordStart += count;
      }
    }
    if (wordStart == word.length() && abbrStart == abbr.length()) return true;
    return false;
  }

  public static void main(String[] args) {
    Prob408 prob408 = new Prob408();
    System.out.println(prob408.validWordAbbreviation("internationalization", "i12iz4n"));
    System.out.println(prob408.validWordAbbreviation("apple", "a2e"));
    System.out.println(prob408.validWordAbbreviation("a", "01"));
  }
}
