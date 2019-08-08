package com.leet.algo;

public class Prob97 {
	public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) return false;
        return isInterleave(s1, s2, s3, 0, 0, 0);
    }
	private boolean isInterleave(String s1, String s2, String s3, int i, int j, int k) {
		if (k == s3.length()) return true;
		if (i < s1.length() && s3.charAt(k) == s1.charAt(i) && j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
    		return isInterleave(s1, s2, s3, i + 1, j, k + 1) || isInterleave(s1, s2, s3, i, j + 1, k + 1);
    	}
		else if (i < s1.length() && s3.charAt(k) == s1.charAt(i)) {
    		return isInterleave(s1, s2, s3, i + 1, j, k + 1);
    	}
		else if (j < s2.length() && s3.charAt(k) == s2.charAt(j)) {
    		return isInterleave(s1, s2, s3, i, j + 1, k + 1);
    	}
		else return false;
	}
	
	public static void main(String[] args) {
		Prob97 prob = new Prob97();
		System.out.println(prob.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
		
	}
}
