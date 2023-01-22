package com.prep2020.medium;

public class Problem758 {
	public String boldWords(String[] words, String S) {
        int n = S.length();
        boolean[] arr = new boolean[n];
        for (int i = 0; i < n; i++) {
        	for (String w : words) {
        		boolean matched = true;
        		for (int j = 0; j < w.length(); j++) {
        			if (i + j == n || S.charAt(i + j) != w.charAt(j)) {
        				matched = false;
        				break;
        			}
        		}
        		if (matched) {
        			for (int j = 0; j < w.length(); j++) arr[i + j] = true;
        		}
        	}
        }
        StringBuilder sb = new StringBuilder();
        boolean started = false;
        for (int i = 0; i < n; i++) {
        	if (arr[i]) {
        		if (!started) {
        			sb.append("<b>");
        			started = true;
        		}
        	} else {
        		if (started) {
        			sb.append("</b>");
        			started = false;
        		}
        	}
        	sb.append(S.charAt(i));
        }
        if (started) sb.append("</b>");
        return sb.toString();
    }
}
