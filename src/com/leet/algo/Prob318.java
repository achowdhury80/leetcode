package com.leet.algo;

/**
 * Created by ayanc on 1/23/18.
 */
public class Prob318 {
  public int maxProduct(String[] words) {
    if(words == null || words.length < 2) return 0;
    int[] value = new int[words.length];
    int i = -1;
    for(String word : words){
      i++;
      char[] chars = word.toCharArray();
      for(char c : chars){
        value[i] |= 1 << (c - 'a');
      }
    }
    int result = 0;
    for(i = 0; i < words.length - 1; i++){
      for(int j = i + 1; j < words.length; j++){
        int p;
        if((value[i] & value[j]) == 0 & (p = words[i].length() * words[j].length()) > result) result = p;
      }
    }
    return result;
  }

  public static void main(String[] args){
    Prob318 prob318 = new Prob318();
    System.out.println(prob318.maxProduct(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}));
    System.out.println(prob318.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
    System.out.println(prob318.maxProduct(new String[]{"a", "aa", "aaa", "aaaa"}));
  }
}
