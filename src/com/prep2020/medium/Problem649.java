package com.prep2020.medium;

public class Problem649 {
	public String predictPartyVictory(String senate) {
		char[] arr = senate.toCharArray();
		int n = arr.length;
		
		boolean changed = true;
		int rCount = 0, dCount = 0;
		while(changed) {
			changed = false;
			for (int i = 0; i < n; i++) {
				if (arr[i] == 'R') {
					if (dCount > 0) {
						dCount--;
						arr[i] = '0';
						changed = true;
					} else {
						rCount++;
					}
				} else if (arr[i] == 'D') {
					if (rCount > 0) {
						rCount--;
						arr[i] = '0';
						changed = true;
					} else {
						dCount++;
					}
				}
			}
		}
		for (int i = 0; i < n; i++) {
			if (arr[i] == 'R') return "Radiant";
			if (arr[i] == 'D') return "Dire";
		}
		return null;
    }
	
	
}
