package com.prep2020.medium;
import java.util.*;
public class Problem131 {
	/**
	 * caching did not give better performance
	 * O(N*(2^n)) time and O(N) space
	 * @param s
	 * @return
	 */
	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();
        partition(result, s, 0, new ArrayList<>());
        return result;
    }
	
	private void partition(List<List<String>> result, String s, int start, 
			List<String> temp) {
		if (start == s.length()) {
			result.add(new ArrayList<>(temp));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			String sub = s.substring(start, i + 1);
			if (isPal(sub)) {
				temp.add(sub);
				partition(result, s, i + 1, temp);
				temp.remove(temp.size() - 1);
			}
		}
	}
	private boolean isPal(String s) {
	    int i = 0, j = s.length() - 1;
	    while (i < j){
	      if (s.charAt(i) != s.charAt(j)) return false;
	      i++;
	      j--;
	    }
	    return true;
	}
	
}
