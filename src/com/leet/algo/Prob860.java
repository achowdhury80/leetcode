package com.leet.algo;

public class Prob860 {
	public boolean lemonadeChange(int[] bills) {
        if (bills.length < 1) return true;
        int fives = 0;
        int tens = 0;
        for (int i = 0; i < bills.length; i++) {
        	if (bills[i] == 5) fives++;
        	else if (bills[i] == 10) {
        		if (fives == 0) return false;
        		fives--;
        		tens++;
        	} else {
        		if (fives == 0 ||(tens == 0 && fives < 3)) return false;
        		fives--;
        		if (tens > 0) {
        			tens--;
        		} else fives -= 2;
        	}
        }
        return true;
    }
}
