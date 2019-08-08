package com.leet.algo;

public class Prob997 {
	public int findJudge(int N, int[][] trust) {
		boolean[] notJudge = new boolean[N + 1];
        int[] trustee = new int[N + 1];
        for (int i = 0; i < trust.length; i++) {
        	notJudge[trust[i][0]] = true;
        	trustee[trust[i][1]]++;
        }
        for (int i = 1; i <= N; i++) {
        	if (trustee[i] == N - 1 && !notJudge[i]) return i;
        }
        return -1;
    }
}
