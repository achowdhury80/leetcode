package com.prep2020.easy;

public class Problem2129 {
	public String capitalizeTitle(String title) {
        String[] arr = title.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String s : arr) {
        	if (s.length() < 3) sb.append(s.toLowerCase());
        	else {
        		s = s.toLowerCase();
        		sb.append(Character.toUpperCase(s.charAt(0))).append(s.substring(1));
        	}
        	sb.append(" ");
        }
        return sb.substring(0, sb.length() - 1);
    }
}
