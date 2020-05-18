package com.leet.algo;
import java.util.*;
public class Prob844 {
	public boolean backspaceCompare(String S, String T) {
        return normalize(S.toCharArray()).equals(normalize(T.toCharArray()));
    }
	
	private String normalize(char[] arr) {
		Stack<Character> s = new Stack<>();
		for (char c : arr) {
			if (c == '#') {
				if (!s.isEmpty()) s.pop();
			} else s.push(c);
		}
		StringBuilder sb = new StringBuilder();
		while(!s.isEmpty())sb.append(s.pop());
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Prob844 prob = new Prob844();
		System.out.println(prob.backspaceCompare(
				"nzp#o#g",
				"b#nzp#o#g"));
	}
}
