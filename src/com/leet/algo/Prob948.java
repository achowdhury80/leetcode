package com.leet.algo;
import java.util.*;
public class Prob948 {
	public int bagOfTokensScore(int[] tokens, int P) {
		if (tokens.length < 1) return 0;
        Arrays.sort(tokens);
        if (P < tokens[0]) return 0;
        P -= tokens[0];
        int point = 1;
        int i = 1, j = tokens.length - 1;
        int[] pSum = new int[tokens.length];
        for (int k = 1; k < tokens.length; k++) pSum[k] = pSum[k - 1] + tokens[k];
        return bagOfTokensScore(tokens, i, j, point, P, pSum);
    }
	
	private int bagOfTokensScore(int[] tokens, int i, int j, int point, int p, int[] pSum) {
		if (pSum[j] - pSum[i - 1] <= p) return point + j - i + 1;
		if (i == j) return point;
		if (pSum[j - 1] - pSum[i - 1] <= p) return point + j - i;
		return bagOfTokensScore(tokens, i, j - 1, point - 1, p + tokens[j], pSum);
	}
}
