package com.leet.algo;
import java.util.*;
public class Prob187 {
	public List<String> findRepeatedDnaSequences(String s) {
		char[] arr = s.toCharArray();
		List<String> result = new ArrayList<>();
		if (arr.length < 11) return result;
		Map<Character, Integer> charMap = new HashMap<>();
		charMap.put('A', 0);
	    charMap.put('C', 1);
	    charMap.put('G', 2);
	    charMap.put('T', 3);
	    int v = 0;
	    int mask = (1 << 20) - 1;
	    Set<Integer> words = new HashSet<>();
	    Set<Integer> doubleWords = new HashSet<>();
	    StringBuilder sb = new StringBuilder();
	    for (int i = 0; i < arr.length; i++) {
	    	char c = arr[i];
	    	v <<= 2;
	    	v |= charMap.get(c);
	    	v &= mask;
	    	sb.append(c); 
	    	if (sb.length() > 10) sb.deleteCharAt(0);
	    	String st = sb.toString();
	    	if (st.length() == 10 && !words.add(v) && doubleWords.add(v)) result.add(st);
	    }
	    return result;
	    
	}
}
