package com.prep2020.hard;

import java.util.*;

public class Problem68 {
	public List<String> fullJustify(String[] words, int maxWidth) {
		int n = words.length;
		List<String> temp = new ArrayList<>(), result = new ArrayList<>();
		int count = 0, letterCount = 0;
		for (int i = 0; i < n; i++) {
			count += words[i].length();
			letterCount += words[i].length();
			if (temp.size() > 0) count++; // for space
			if (count > maxWidth) {
				count -= words[i].length();
				letterCount -= words[i].length();;
				count--; // for space
				i--;
				result.add(adjust(temp, letterCount, maxWidth, false));
				temp.clear();
				count = 0;
				letterCount = 0;
			} else {
				temp.add(words[i]);
			}
		}
		result.add(adjust(temp, letterCount, maxWidth, true));
		return result;
    }
	
	private String adjust(List<String> strings, int letterCount, int maxWidth, boolean last) {
		if (last || strings.size() == 1) {
			String result = String.join(" ", strings);
			while(result.length() < maxWidth) result += " ";
			return result;
		}
		int n = strings.size();
		int numberOfSpaces = maxWidth - letterCount;
		int rem = numberOfSpaces % (n - 1), gap = numberOfSpaces / (n - 1);
		StringBuilder sb = new StringBuilder(strings.get(0));
		String gapSpace = "";
		for (int i = 0; i < gap; i++) gapSpace += " ";
		for (int i = 1; i < strings.size(); i++) {
			sb.append(gapSpace);
			if (rem > 0) {
				sb.append(" ");
				rem--;
			}
			sb.append(strings.get(i));
		}
		return sb.toString();
	}
}
