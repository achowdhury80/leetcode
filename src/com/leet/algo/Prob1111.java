package com.leet.algo;

public class Prob1111 {
	public int[] maxDepthAfterSplit(String seq) {
        char[] arr = seq.toCharArray();
        int[] result = new int[arr.length];
        int depth = -1;
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == '(') depth++;
        	if (depth % 2 == 0) result[i] = 0;
        	else result[i] = 1;
        	if (arr[i] == ')') depth++;
        }
        return result;
    }

}
