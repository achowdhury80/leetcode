package com.prep2020.easy;

public class Problem1592 {
	public String reorderSpaces(String text) {
        int wordCount = 0, spaceCount = 0;
        boolean lastSpace = true;
        for (char c : text.toCharArray()) {
        	if (c == ' ') {
        		lastSpace = true;
        		spaceCount++;
        	} else {
        		if (lastSpace) wordCount++;
        		lastSpace = false;
        	}
        }
        int spaceBetween = 0;
        int lastSpaces = spaceCount;
        if (wordCount > 1) {
        	spaceBetween = spaceCount / (wordCount - 1);
        	lastSpaces = spaceCount % (wordCount - 1);
        }
        int betweenCount = wordCount - 1;
        String spaces = "";
        for (int i = 0; i < spaceBetween; i++) spaces += " ";
        StringBuilder result = new StringBuilder();
        lastSpace = true;
        for (char c : text.toCharArray()) {
        	if (c != ' ') {
        		lastSpace = false;
        		result.append(c);
        	} else {
        		if (!lastSpace && betweenCount > 0) {
        			result.append(spaces);
        			betweenCount--;
        		}
        		lastSpace = true;
        	}
        }
        for (int i = 0; i < lastSpaces; i++) result.append(" ");
        return result.toString();
    }
	
	public static void main(String[] args) {
		Problem1592 problem = new Problem1592();
		System.out.println(problem.reorderSpaces("  this   is  a sentence "));
	}
}
