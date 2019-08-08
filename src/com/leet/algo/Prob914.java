package com.leet.algo;
import java.util.*;
public class Prob914 {
	public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length < 2) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : deck) map.put(i, map.getOrDefault(i, 0) + 1);
        int result = 0;
        for (int i : map.values()) {
        	result = gcd(i, result);
        	if (result < 2) break;
        }
        return result > 1;
    }
	private int gcd(int a, int b) {
		return b > 0 ? gcd(b, a % b) : a; 
	}
}
