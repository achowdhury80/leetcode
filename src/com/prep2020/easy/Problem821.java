package com.prep2020.easy;
import java.util.*;
public class Problem821 {
	public int[] shortestToChar(String S, char C) {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < S.length(); i++) {
        	if (C == S.charAt(i)) pos.add(i);
        }
        int[] result = new int[S.length()];
        int idx = 0;
        for (int i = 0; i < S.length(); i++) {
        	if (i >= pos.get(idx)) {
        		result[i] = i - pos.get(idx);
        		if (idx < pos.size() - 1) idx++;
        	} else if (idx == 0) {
        		result[i] = pos.get(idx) - i;
        	} else {
        		if (i - pos.get(idx - 1) <= pos.get(idx) - i) {
        			result[i] = i - pos.get(idx - 1);
        		} else result[i] = pos.get(idx) - i;
        	}
        }
        return result;
    }
}
