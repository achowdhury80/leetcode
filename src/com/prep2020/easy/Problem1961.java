package com.prep2020.easy;

public class Problem1961 {
	public boolean isPrefixString(String s, String[] words) {
        int n = s.length(), i = 0;
        String st = "";
        while(st.length() < n && i < words.length) {
        	st += words[i++];
        }
        return s.equals(st);
    }
}
