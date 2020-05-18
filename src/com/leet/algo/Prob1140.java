package com.leet.algo;
public class Prob1140 {
	public int stoneGameII(int[] piles) {
		int[] postSum = new int[piles.length];
		postSum[piles.length - 1] = piles[piles.length - 1];
		for (int i = piles.length - 2; i > -1; i--) postSum[i] = postSum[i + 1] + piles[i];
		int[][] mem = new int[piles.length][piles.length * 2];
		return helper(piles, 0, 1, mem, postSum);
    }
	
	private int helper(int[] piles, int idx, int M, int[][] mem, int[] postSum) {
		if (idx == piles.length) return 0;
		if (piles.length - idx <= 2 * M) return postSum[idx];
		if (mem[idx][M] != 0) return mem[idx][M];
		int min = Integer.MAX_VALUE;
		for (int i = 1; i <= 2 * M; i++) {
			min = Math.min(min, helper(piles, idx + i, Math.max(M, i), mem, postSum));
		}
		mem[idx][M] = postSum[idx] - min;
		return mem[idx][M];
	}
	
	public static void main(String[] args) {
		Prob1140 prob = new Prob1140();
		System.out.println(prob.stoneGameII(new int[] {2, 7, 9, 4, 4}));
	}
}
