package com.leet.algo;

public class Prob983 {
	public int mincostTickets(int[] days, int[] costs) {
        int[] totalCosts = new int[366];
        int j = 0;
        for (int i = 1; i <= days[days.length - 1]; i++) {
        	if (days[j] == i) {
        		j++;
        		totalCosts[i] = Math.min(totalCosts[i - 1] + costs[0],
        				Math.min(i > 6 ? totalCosts[i - 7] + costs[1] : costs[1], 
        						i > 30 ? totalCosts[i - 30] + costs[2] : costs[2]));
        	} else {
        		totalCosts[i] = totalCosts[i - 1];
        	}
        }
        return totalCosts[days[days.length - 1]];
    }
}
