package com.prep2020.medium;

public class Problem672 {
	public int flipLights(int n, int presses) {
		if(presses == 0) return 1;
	    if(n == 1) return 2;
	    if(n == 2 && presses == 1)  return 3;
	    if(n == 2) return 4;
	    if(presses == 1) return 4;
	    if(presses == 2) return 7;
	    return 8;
    }
}
