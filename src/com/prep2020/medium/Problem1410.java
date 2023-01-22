package com.prep2020.medium;

public class Problem1410 {
	public String entityParser(String text) {
        StringBuilder sb = new StringBuilder();
        int n = text.length();
        for (int i = 0; i < n; i++) {
        	if (text.charAt(i) == '&') {
	        	if (i + 3 < n) {
	        		String s = text.substring(i, i + 4);
	        		if ("&lt;".equals(s)) {
	        			sb.append("<");
	        			i += 3;
	        			continue;
	        		}
	        		if ("&gt;".equals(s)) {
	        			sb.append(">");
	        			i += 3;
	        			continue;
	        		}
	        	}
	        	if (i + 4 < n) {
	        		String s = text.substring(i, i + 5);
	        		if ("&amp;".equals(s)) {
	        			sb.append("&");
	        			i += 4;
	        			continue;
	        		}
	        	}
	        	if (i + 5 < n) {
	        		String s = text.substring(i, i + 6);
	        		if ("&apos;".equals(s)) {
	        			sb.append("'");
	        			i += 5;
	        			continue;
	        		}
	        		if ("&quot;".equals(s)) {
	        			sb.append("\"");
	        			i += 5;
	        			continue;
	        		}
	        	}
	        	if (i + 6 < n) {
	        		String s = text.substring(i, i + 7);
	        		if ("&frasl;".equals(s)) {
	        			sb.append("/");
	        			i += 6;
	        			continue;
	        		}
	        	}
        	}
        	sb.append(text.charAt(i));
        }
        return sb.toString();
    }
}
