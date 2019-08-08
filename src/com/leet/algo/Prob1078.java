package com.leet.algo;

import java.util.*;

public class Prob1078 {
	public String[] findOcurrences(String text, String first, String second) {
        String[] strs = new String[3];
        WordIterator itr = new WordIterator(text);
        for (int i = 0; i < 2; i++) {
        	if (itr.hasNext()) strs[i] = itr.next();
        }
        List<String> list = new ArrayList<>();
        while (itr.hasNext()) {
        	strs[2] = itr.next();
        	if (strs[0].equals(first) && strs[1].equals(second)) list.add(strs[2]);
        	strs[0] = strs[1];
        	strs[1] = strs[2];
        }
        String[] result = new String[list.size()];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
        
    }
	
	class WordIterator implements Iterator<String>{
		String text = null;
		int i;
		WordIterator(String text) {
			this.text = text;
			i = 0;
			while(i < text.length() && text.charAt(i) == ' ') i++;
		}

		@Override
		public boolean hasNext() {
			if (i == text.length()) return false;
			return true;
		}

		@Override
		public String next() {
			// TODO Auto-generated method stub
			StringBuilder sb = new StringBuilder();
			while(i < text.length() && text.charAt(i) != ' ') {
				sb.append(text.charAt(i));
				i++;
			}
			while(i < text.length() && text.charAt(i) == ' ') i++;
			return sb.toString();
		}
	}
}
