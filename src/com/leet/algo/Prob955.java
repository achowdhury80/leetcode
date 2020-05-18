package com.leet.algo;
public class Prob955 {
	public int minDeletionSize(String[] A) {
        int result = 0, n = A[0].length();
        boolean[] deleted = new boolean[n];
        while(true) {
        	boolean restart = false;
        	for (int i = 0; i < A.length - 1; i++) {
        		for (int j = 0; j < n; j++) {
        			if (deleted[j]) continue;
        			if (A[i].charAt(j) < A[i + 1].charAt(j)) break;
        			if (A[i].charAt(j) > A[i + 1].charAt(j)) {
        				result++;
        				if (result == n) return result;
        				deleted[j] = true;
        				restart = true;
        				break;
        			}
        		}
        	}
        	if(!restart) break;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob955 prob = new Prob955();
		System.out.println(prob.minDeletionSize(new String[] {"abx","agz","bgc","bfc"}));
		//System.out.println(prob.minDeletionSize(new String[] {"zyx","wvu","tsr"}));
	}
}
