package comp.prep2019;

import java.util.*;

public class Prob451 {
	/**
	 * O(NLogN)
	 * @param s
	 * @return
	 */
	public String frequencySort(String s) {
	    if(s == null || s.length() == 0) return s;
	    Map<Character, StringBuilder> map = new HashMap<>();

	    for(int i = 0; i < s.length(); i++){
	      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), new StringBuilder()).append(s.charAt(i)));
	    }
	    List<StringBuilder> col = new ArrayList<>(map.values());
	    Collections.sort(col, (x, y) -> y.length() - x.length());
	    StringBuilder result = new StringBuilder();
	    for (StringBuilder st : col) result.append(st);
	    return result.toString();
	  }
}
