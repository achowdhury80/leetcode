package com.prep2020.medium;

public class Problem470 {
	public int rand10() {
        int a = 7, b = 7;
        while(a == 7) a = rand7();
        while(b > 5) b = rand7();
        return b + (a < 4 ? 0 : 5);
    }
	
	public int rand7() {
		return 0;
	}
}
