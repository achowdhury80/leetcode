package com.prep2020.medium;
import java.util.*;
public class Problem388 {
	public int lengthLongestPath(String input) {
        Map<Integer, String> map = new HashMap<>();
        int result = 0, start = 0;
        for (int i = 0; i < input.length(); i++) {
        	char c;
        	if (i == input.length() - 1 || (c = input.charAt(i)) == '\n') {
        		String path = input.substring(start, (i == input.length() - 1) ? 
        				(i + 1) : i);
        		start = i + 1;
        		int tabCount = 0;
        		String filrDir = "";
        		for (int j = 0; j < path.length(); j++) {
        			if (path.charAt(j) == '\t') {
        				tabCount++;
        			} else {
        				filrDir = path.substring(j);
        				break;
        			}
        		}
        		if (map.containsKey(tabCount))
        			path = map.get(tabCount) + "\\" + filrDir;
        		if (filrDir.indexOf('.') > -1) {
        			result = Math.max(result, path.length());
        		} else {
        			map.put(tabCount + 1, path);
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem388 problem = new Problem388();
		System.out.println(problem.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
	}
}
