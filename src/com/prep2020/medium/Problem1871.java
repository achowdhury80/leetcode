package com.prep2020.medium;
import java.util.*;
public class Problem1871 {
	public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        char[] arr = s.toCharArray();
        Queue<Integer> q = new PriorityQueue<>((x, y) -> y - x);
        q.offer(0);
        arr[0] = '1';
        while(!q.isEmpty()) {
        	int idx = q.poll();
        	if (idx == n - 1) return true;
        	for (int j = minJump; j <= maxJump; j++) {
        		if (idx + j >= n) break;
        		if (arr[idx + j] == '1') continue;
        		arr[idx + j] = '1';
        		q.offer(idx + j);
        	}
        }
        return false;
    }
}
