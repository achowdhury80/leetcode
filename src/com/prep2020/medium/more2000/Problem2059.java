package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2059 {
	public int minimumOperations(int[] nums, int start, int goal) {
        if (start == goal) return 0;
        boolean[] used = new boolean[1001];
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        used[start] = true;
        int result = 0;
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int cur = q.poll();
        		for (int num : nums) {
        			if (cur + num == goal || cur - num == goal || (cur ^ num) == goal) return result;
        			if (cur + num < 1001 && cur + num > -1 && !used[cur + num]) {
        				used[cur + num] = true;
        				q.offer(cur + num);
        			}
        			if (cur - num > -1 && cur - num < 1001 && !used[cur - num]) {
        				used[cur - num] = true;
        				q.offer(cur - num);
        			}
        			if ((cur ^ num) < 1001 && (cur ^ num) > -1 && !used[cur ^ num]) {
        				used[cur ^ num] = true;
        				q.offer(cur ^ num);
        			}
        		}
        	}
        }
        return -1;
    }
}
