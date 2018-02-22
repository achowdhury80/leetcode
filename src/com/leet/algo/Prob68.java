package com.leet.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ayanc on 2/20/18.
 */
public class Prob68 {
  public List<String> fullJustify(String[] words, int maxWidth) {
    return fullJustify(words, maxWidth, 0);
  }

  private List<String> fullJustify(String[] words, int maxWidth, int start) {
    List<String> result = new ArrayList<>();
    int i = start;
    int runningSum = words[i].length();
    int lettercount = words[i++].length();
    while (i < words.length && (runningSum += 1 + words[i].length()) <= maxWidth) {
      lettercount += words[i].length();
      i++;
    }
    result.add(helper(words, start, i - start, maxWidth, i == words.length, maxWidth - lettercount));
    if (i < words.length) result.addAll(fullJustify(words, maxWidth, i));
    return result;
  }

  private String helper(String[] words, int start, int length, int maxWidth, boolean last, int spaceCount) {
    char[] chars = new char[maxWidth];
    Arrays.fill(chars, 0, chars.length, ' ');
    int count = 0;
    if (last) {
      for (int i = 0; i < length; i++) {
        for (int j = 0; j < words[start + i].length(); j++)
          chars[count++] = words[start + i].charAt(j);
        count++;
      }
      return new String(chars);
    }

    count = maxWidth - 1;
    for (int i = start + length - 1; i > start; i--) {
      for (int j = words[i].length() - 1; j > -1; j--) {
        chars[count--] = words[i].charAt(j);
      }
      int space = spaceCount / (i - start);
      spaceCount -= space;
      count -= space;
    }
    count = 0;
    for (int i = 0; i < words[start].length(); i++) {
      chars[count++] = words[start].charAt(i);
    }
    return new String(chars);
  }

  public static void main(String[] args) {
    Prob68 prob68 = new Prob68();
    System.out.println(prob68.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
  }
}
