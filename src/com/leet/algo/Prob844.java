package com.leet.algo;
public class Prob844 {
	public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        char[] s = S.toCharArray(), t = T.toCharArray();
        Character charS = null, charT = null;
        while(i > -1 & j > -1) {
        	int skip = 0;
        	while(i > -1 && (s[i] == '#' || skip > 0)) {
        		if (s[i] == '#') skip++;
        		else skip--;
        		i--;
        	}
        	if (i > -1) charS = s[i--];
        	skip = 0;
        	while(j > -1 && (t[j] == '#' || skip > 0)) {
        		if (t[j] == '#') skip++;
        		else skip--;
        		j--;
        	}
        	if (j > -1) charT = t[j--];
        	if (charS != charT) return false;
        	
        }
        if (i > -1) {
        	int skip = 0;
        	while(i > -1 && (s[i] == '#' || skip > 0)) {
        		if (s[i] == '#') skip++;
        		else skip--;
        		i--;
        	}
        	if (i > -1) return false;
        } else if (j > -1) {
        	int skip = 0;
        	while(j > -1 && (t[j] == '#' || skip > 0)) {
        		if (t[j] == '#') skip++;
        		else skip--;
        		j--;
        	}
        	if (j > -1) return false;
        }
        if (i < 0 && j < 0) return true;
        return false;
        
    }
	
	public static void main(String[] args) {
		Prob844 prob = new Prob844();
		System.out.println(prob.backspaceCompare(
				"nzp#o#g",
				"b#nzp#o#g"));
	}
}
