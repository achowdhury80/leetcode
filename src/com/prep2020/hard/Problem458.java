package com.prep2020.hard;

public class Problem458 {
	/**
	 * inspired from https://leetcode.com/problems/poor-pigs/solution/
	 * @param buckets
	 * @param minutesToDie
	 * @param minutesToTest
	 * @return
	 */
	public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {
		int states = minutesToTest / minutesToDie + 1;
		int val = (int)Math.ceil(Math.log(buckets) / Math.log(states));
		if (Math.pow(states, val - 1) >= buckets) return val - 1;
		return val;
    }
	
	public static void main(String[] args) {
		Problem458 problem = new Problem458();
		System.out.println(problem.poorPigs(125, 1, 4));
	}
}
