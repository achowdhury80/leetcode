package com.prep2020.easy;
import java.util.*;
public class Problem1331 {
	public int[] arrayRankTransform(int[] arr) {
		if (arr.length == 0) return arr;
        Queue<Integer> q = new PriorityQueue<>((x, y) -> arr[x] - arr[y]);
        for (int i = 0; i < arr.length; i++) q.offer(i);
        int[] result = new int[arr.length];
        int rank = 1;
        int lastIndex = q.poll();
        result[lastIndex] = rank; 
        while(!q.isEmpty()) {
        	int curIndex = q.poll();
        	if (arr[curIndex] != arr[lastIndex]) rank++;
        	result[curIndex] = rank;
        	lastIndex = curIndex;
        }
        return result;
    }
}
