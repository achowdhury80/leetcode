package com.prep2020.hard;

public class Problem2167 {
	public int minimumTime(String s) {
        int n = s.length();
        int[] leftCost = new int[n];
        int openCost = 0, closedCost = 0;
        boolean goodFound = false;
        for (int i = 0; i < n; i++) {
        	if (s.charAt(i) == '1') {
        		closedCost += goodFound ? 2 : 1;
        	} else goodFound = true;
        	openCost++;
        	if (closedCost >= openCost) closedCost = openCost;
        	leftCost[i] = Math.min(openCost, closedCost);
        	
        }
        
        openCost = 0; 
        closedCost = 0;
        goodFound = false;
        int result = Integer.MAX_VALUE;
        for (int i = n - 1; i > -1; i--) {
        	if (s.charAt(i) == '1') {
        		closedCost += goodFound ? 2 : 1;
        	} else goodFound = true;
        	openCost++;
        	if (closedCost >= openCost) closedCost = openCost;
        	result = Math.min(result, Math.min(openCost, closedCost) + (i > 0 ? leftCost[i - 1] : 0));
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2167 problem = new Problem2167();
		//System.out.println(problem.minimumTime("0010"));
		System.out.println(problem.minimumTime("0111001110"));
	}

}
