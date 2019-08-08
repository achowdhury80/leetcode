package com.leet.algo;

public class Prob1033 {
	public int[] numMovesStones(int a, int b, int c) {
        if (a > b) {
        	int temp = a;
        	a = b;
        	b = temp;
        }
        if (a > c) {
        	int temp = a;
        	a = c;
        	c = temp;
        }
        if (b > c) {
        	int temp = b;
        	b = c;
        	c = temp;
        }
        
        int[] result = new int[2];
        if (b - a == 2 || c - b == 2) result[0] = 1;
        else {
        	result[0] = (b - a > 1 ? 1 : 0) + (c - b > 1 ? 1 : 0);
        }
        result[1] = c - a - 2;
        return result;
    }
}
