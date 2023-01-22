package com.prep2020.easy;

public class Problem1518 {
	/**
	 * O(log numBottles / log numExchange)
	 * @param numBottles
	 * @param numExchange
	 * @return
	 */
	public int numWaterBottles(int numBottles, int numExchange) {
		int result = numBottles;
		while(numBottles >= numExchange) {
			result += numBottles / numExchange;
			numBottles = (numBottles % numExchange) + (numBottles / numExchange);
		}
		return result;
	}
}
