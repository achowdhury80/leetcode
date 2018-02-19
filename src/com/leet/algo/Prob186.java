package com.leet.algo;

/**
 * Created by ayanc on 2/17/18.
 */
public class Prob186 {
  public void reverseWords(char[] str) {
    reverse(str, 0, str.length - 1);
    for (int i = 0; i < str.length; i++) {
      if (str[i] != ' ') {
        int j = i + 1;
        while (j < str.length && str[j] != ' ') j++;
        j--;
        reverse(str, i, j);
        i = j;
      }
    }
  }

  private void reverse(char[] str, int start, int end) {
    while(start < end) {
      char c = str[start];
      str[start] = str[end];
      str[end] = c;
      start++;
      end--;
    }
  }

  public static void main(String[] args) {
    Prob186 prob186 = new Prob186();
    char[] arr = "the sky is blue".toCharArray();
    prob186.reverseWords(arr);
    System.out.println(new String(arr));
  }
}
