package com.prep2020.medium;
import java.util.*;
public class Problem1943 {
	public List<List<Long>> splitPainting(int[][] segments) {
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> (x[0] == y[0] ? (x[1] - y[1]) : (x[0] - y[0])));
        for (int[] seg : segments) {
        	pq.offer(new int[] {seg[0], 1, seg[2]});
        	pq.offer(new int[] {seg[1], 0, seg[2]});
        }
        List<List<Long>> result = new ArrayList<>();
        long cur = 0;
        int start = -1, last = -1;
        while(!pq.isEmpty()) {
        	int[] top = pq.poll();
        	if (top[0] == last) {
        		if (top[1] == 1) {
        			cur += top[2];
        			if (start == -1) start = top[0];
        		}
        		else cur -= top[2];
        	} else {
        		if (cur == 0) {
        			start = top[0];
        			last = top[0];
        			cur += top[2];
        		} else {
        			List<Long> list = new ArrayList<>();
        			list.add(0l + start);
        			list.add(0l + top[0]);
        			list.add(cur);
        			result.add(list);
        			if (top[1] == 1) {
        				cur += top[2];
        			} else {
        				cur -= top[2];
        			}
        			if (cur == 0) {
        				start = -1;
        			} else start = top[0];
        			last = top[0];
        			
        		}
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1943 problem = new Problem1943();
		System.out.println(problem.splitPainting(new int[][] {{1, 7, 9}, {6, 8, 15}, {8, 10, 7}}));
	}
}
