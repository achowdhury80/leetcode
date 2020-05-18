package comp.prep2019;

import java.util.*;

public class Prob522 {
	public int findLUSlength(String[] strs) {
		Arrays.sort(strs, (x, y) -> y.length() - x.length());
		Set<String> candidates = new HashSet<>(), ignored = new HashSet<>();
		int currentLength = -1;
		for (String st : strs) {
			if (candidates.contains(st)) {
				candidates.remove(st);
				ignored.add(st);
				if (candidates.isEmpty()) {
					currentLength = -1;
				}
			} else {
				if (st.length() < currentLength) return currentLength;
				if (isSubsequence(st, ignored)) continue;
				candidates.add(st);
				currentLength = st.length();
			}
		}
		return candidates.isEmpty() ? -1 : currentLength;
	}
		
	 private boolean isSubsequence(String st, Set<String> ignoredSet) {
	    if(ignoredSet.isEmpty()) return false;
	    for (String s : ignoredSet) if(isSubsequence(s, st)) return true;
	    return false;
	  }

	  private boolean isSubsequence(String biggger, String smaller){
	    int j = 0;
	    for (int i = 0; i < biggger.length() && j < smaller.length(); ){
	      char charFromBigger = biggger.charAt(i);
	      char charFromSmaller = smaller.charAt(j);
	      if(charFromSmaller == charFromBigger){
	        i++;
	        j++;
	      } else if(charFromSmaller != charFromBigger) i++;
	    }
	    if (j == smaller.length()) return true;
	    return false;
	  }
   
}
