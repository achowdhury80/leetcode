package com.prep2020.medium.more2000;

import java.util.Arrays;

public class Problem2274 {
	public int maxConsecutive(int bottom, int top, int[] special) {
        Arrays.sort(special);
        if (special.length == 0 || top < special[0] || bottom > special[special.length - 1]) return top - bottom + 1;
        int cur = bottom;
        int result = 0;
        for (int s :special) {
        	if (s < bottom) continue;
        	if (s == cur) {
        		cur++;
        		if (cur > top) break;
        	}
        	else if (s > top) {
        		result = Math.max(result, top - cur + 1);
        		break;
        	} else {
        		result = Math.max(result, s - cur);
        		cur = s + 1;
        		if (cur > top) break;
        	}
        }
        if (special[special.length - 1] < top) result = Math.max(result, top - special[special.length - 1]);
        return result;
    }
	
	public static void main(String[] args) {
		Problem2274 problem = new Problem2274();
		System.out.println(problem.maxConsecutive(2, 9, new int[] {4, 6}));
	}
}
