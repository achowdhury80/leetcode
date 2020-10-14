package comp.prep2019.less1000;

import java.util.*;

public class Prob720 {
	/**
	 * O(NlogN) time and O(N) space
	 * first sort words in increasing order of size and lex decreaing
	 * capture the word and its index in a map
	 * keep a boolean array to keep track of tried words
	 * start from end of the array
	 * try to remove a char from the end at a time and check if it is in map
	 * if it is in map, set the tried index to true 
	 * @param words
	 * @return
	 */
	public String longestWord(String[] words) {
      Arrays.sort(words, (x, y) -> x.length() == y.length() ? y.compareTo(x) : x.length() - y.length());  
      boolean[] tried = new boolean[words.length];
      Map<String, Integer> map = new HashMap<>();
      for (int i = 0; i < words.length; i++) map.put(words[i], i);
      for (int i = words.length - 1; i > -1; i--) {
    	  if (tried[i] == true) continue;
    	  tried[i] = true;
    	  String w = words[i];
    	  while(map.containsKey(w) && w.length() > 0) {
    		  tried[map.get(w)] = true;
    		  w = w.substring(0, w.length() - 1);
    	  }
    	  if (w.length() == 0) return words[i];
      }
      return "";
    }
}
