package com.prep2020.medium;
import java.util.*;
public class Problem524 {
	public String findLongestWord(String s, List<String> dictionary) {
		Collections.sort(dictionary, (x, y) -> (x.length() == y.length() ? 
				(x.compareTo(y)) : (y.length() - x.length())));
		for (String w : dictionary) {
			if (w.length() > s.length()) continue;
			int i = 0, j = 0;
			while(i < s.length() && j < w.length()) {
				if (s.charAt(i) == w.charAt(j)) {
					j++;
				}
				i++;
			}
			if (j == w.length()) return w;
		}
		return "";
    }
}
