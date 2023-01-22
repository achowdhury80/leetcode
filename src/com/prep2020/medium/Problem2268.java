package com.prep2020.medium;
import java.util.*;
public class Problem2268 {
	public int minimumKeypresses(String s) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
        	arr[c - 'a']++;
        }
        Queue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i : arr) {
        	if (i > 0) pq.offer(i);
        }
        int result = 0;
        int press = 1, charsMapped = 0;
        while(!pq.isEmpty()) {
        	int val = pq.poll();
        	result += val * press;
        	charsMapped++;
        	if (charsMapped % 9 == 0) press++;
        }
        return result;
    }
}
