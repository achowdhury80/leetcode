package com.prep2020.medium;
public class Problem1599 {
	public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int profit = 0, maxProfit = -1, result = -1;
        int n = customers.length;
        int rem = 0;
        int ride = 0;
        for (int i = 0; i < n; i++) {
        	ride++;
        	profit -= runningCost;
        	customers[i] += rem;
        	rem = 0;
        	int boarded = Math.min(4, customers[i]);
        	profit += boarded * boardingCost;
        	if (profit > 0 && profit > maxProfit) {
        		maxProfit = profit;
        		result = ride;
        	}
        	rem = customers[i] - boarded;
        }
        while(rem > 0) {
        	ride++;
        	profit -= runningCost;
        	int boarded = Math.min(4, rem);
        	profit += boarded * boardingCost;
        	if (profit > 0 && profit > maxProfit) {
        		maxProfit = profit;
        		result = ride;
        	}
        	rem -= boarded;
        }
        return result;
    }	
	
	public static void main(String[] args) {
		Problem1599 problem = new Problem1599();
		System.out.println(problem.minOperationsMaxProfit(new int[] {8, 3}, 5, 6));
	}
}
