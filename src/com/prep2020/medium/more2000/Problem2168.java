package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2168 {
	public int equalDigitFrequency(String s) {
		int n = s.length();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
        	int[] count = new int[10];
        	String st = "";
        	for (int j = i; j < n; j++) {
        		int idx = s.charAt(j) - '0';
        		st += s.charAt(j);
        		count[idx]++;
        		if (hasSameFreq(count)) {
        			set.add(st);
        		}
        	}
        }
        return set.size();
    }
	
	private boolean hasSameFreq(int[] count) {
		int freq = -1;
		for (int i = 0; i < 10; i++) {
			if (count[i] == 0) continue;
			if (freq == -1) freq = count[i];
			else if (freq != count[i]) return false;
		}
		return true;
	}
}
