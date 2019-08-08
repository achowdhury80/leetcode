package com.leet.algo;
import java.util.*;
public class Prob816 {
	public List<String> ambiguousCoordinates(String S) {
        int n = S.length();
        List<String> result = new ArrayList<>();
        for (int i = 2; i < S.length() - 1; i++) {
        	if (isValidForCommaSeparation(S, 1, i - 1) && isValidForCommaSeparation(S, i, n - 2)) {
        		List<String> variation1 = findVariations(S, 1, i - 1);
        		List<String> variation2 = findVariations(S, i, n - 2);
        		for (String var1 : variation1) {
        			for (String var2 : variation2) {
        				result.add("(" + var1 + ", " + var2 + ")");
        			}
        		}
        	}
        }
        return result;
    }
	
	private boolean isValidForCommaSeparation(String s, int i, int j) {
		if (i == j || s.charAt(i) != '0') return true;
		if (s.charAt(i) == '0' && s.charAt(j) == '0') return false;
		return true;
	}
	
	private List<String> findVariations(String s, int i, int j) {
		List<String> result = new ArrayList<>();
		if (i == j) {
			result.add("" + s.charAt(i));
			return result;
		}
		if (s.charAt(i) == '0') {
			result.add("0." +  s.substring(i + 1, j + 1));
			return result;
		}
		if (s.charAt(j) == '0') {
			result.add(s.substring(i, j + 1));
			return result;
		}
		if (s.charAt(i) != '0') result.add(s.substring(i, j + 1));
		if (j > i && s.charAt(i) == '0' && s.charAt(i + 1) == '0') {
			result.add("" + s.charAt(i) + "." + s.substring(i + 1, j + 1));
			return result;
		}
		for (int k = i; k < j; k++) {
			result.add(s.substring(i, k + 1) + "." + s.substring(k + 1, j + 1));
		}
		return result;
	}
	
	public static void main(String[] args) {
		Prob816 prob = new Prob816();
		//System.out.println(prob.ambiguousCoordinates("(00011)"));
		//System.out.println(prob.ambiguousCoordinates("(123)"));
		System.out.println(prob.ambiguousCoordinates("(100)"));
	}
}
