package com.prep2020.medium;

public class Problem1989 {
	public int catchMaximumAmountofPeople(int[] team, int dist) {
        int notItIndex = findNextNotItIndex(team, -1);
        int itIndex = -1;
        int result = 0;
        while(notItIndex != -1) {
        	itIndex++;
        	while(itIndex < team.length && team[itIndex] != 1) itIndex++;
        	if(itIndex == team.length) break;
        	while(notItIndex < itIndex - dist) {
        		notItIndex = findNextNotItIndex(team, notItIndex);
        		if (notItIndex == -1) break;
        	}
        	if (notItIndex == -1) break;
        	if (notItIndex >= (itIndex - dist) && notItIndex <= (itIndex + dist)) {
        		result++;
        		notItIndex = findNextNotItIndex(team, notItIndex);
        	} 
        }
        return result;
    }
	
	private int findNextNotItIndex(int[] team, int curIndex) {
		for (int i = curIndex + 1; i < team.length; i++) {
			if (team[i] == 0) return i;
		}
		return -1;
	}
}
