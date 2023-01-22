package com.prep2020.medium;
import java.util.*;
public class Problem71 {
	public String simplifyPath(String path) {
		Deque<String> stack = new ArrayDeque<>();
		String curDir = "";
        for (int i = 0; i <= path.length(); i++) {
        	char c = i == path.length() ? '/' : path.charAt(i);
        	if (c == '/') {
        		if ("".equals(curDir) || ".".equals(curDir)) {
        			curDir = "";
        			continue;
        		}
        		if ("..".equals(curDir)) {
        			if (stack.size() > 0) stack.pop();
        			curDir = "";
        			continue;
        		}
        		stack.push(curDir);
        		curDir = "";
        	} else curDir += c;
        }
        if (stack.isEmpty()) return "/";
        StringBuilder sb = new StringBuilder("");
        while(!stack.isEmpty()) sb.insert(0, "/" + stack.pop());
        return sb.toString();
    }
}
