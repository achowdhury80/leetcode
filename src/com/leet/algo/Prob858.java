package com.leet.algo;

public class Prob858 {
	public int mirrorReflection(int p, int q) {
		int lcm = 0;
        for (int i = 1; i <= q; i++) {
        	if ((i * p) % q == 0) {
        		lcm = i * p;
        		break;
        	}
        }
        if ((lcm / q) % 2 == 0) return 2;
        if ((lcm / p) % 2 == 1) return 1;
        return 0;
    }
}
