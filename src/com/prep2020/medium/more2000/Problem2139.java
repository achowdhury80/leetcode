package com.prep2020.medium.more2000;

public class Problem2139 {
	public int minMoves(int target, int maxDoubles) {
		if (target == 1) return 0;
        if (maxDoubles == 0) return target - 1;
        if (target % 2 == 1) return 1 + minMoves(target - 1, maxDoubles);
        return 1 + minMoves(target / 2, maxDoubles - 1);
    }
}
