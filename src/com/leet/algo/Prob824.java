package com.leet.algo;

public class Prob824 {
	public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        Character ch = null;
        int wordIndex = 0;
        for (int i = 0; i < S.length(); i++) {
        	char c = S.charAt(i);
        	if (c == ' ') {
        		if(ch != null) {
        			if(!isVowel(ch)) {
        				sb.append(ch);
        			} 
        			sb.append("ma");
        			wordIndex++;
        			for(int j = 0; j < wordIndex; j++) sb.append("a");
        		} 
        		sb.append(c);
        		ch = null;
        		
        	} else {
        		if (ch != null) {
        			sb.append(c);
        		} else {
        			ch = c;
        			if (isVowel(c)) sb.append(c);
        		}
        	}
        }
        if (ch != null) {
        	if(!isVowel(ch)) {
				sb.append(ch);
			} 
			sb.append("ma");
			wordIndex++;
			for(int j = 0; j < wordIndex; j++) sb.append("a");
        }
        return sb.toString();
    }
	
	public boolean isVowel(char c) {
		c = Character.toLowerCase(c);
		return "aeiou".indexOf(c) > -1;
	}
}
