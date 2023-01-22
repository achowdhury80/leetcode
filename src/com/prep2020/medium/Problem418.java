package com.prep2020.medium;

public class Problem418 {
	public int wordsTyping(String[] sentence, int rows, int cols) {
        String s = String.join(" ", sentence) + " ";
        int len = s.length(), start = 0;;
        for (int i = 0; i < rows; i++) {
        	start += cols;
        	if (s.charAt(start % len) == ' ') start++;
        	else while(start > 0 && s.charAt((start - 1) % len) != ' ') start--;
        }
        return start / len;
    }
}
