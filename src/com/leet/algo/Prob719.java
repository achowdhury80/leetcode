package com.leet.algo;

import java.util.*;

public class Prob719 {
	public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> (Math.abs(x[0] - x[1]) - Math.abs(y[0] - y[1])));
        for (int i = 0; i < nums.length - 1; i++) pq.offer(new int[] {nums[i], nums[i + 1], i + 1});
        int index = 0;
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if(++index == k) return Math.abs(cur[0] - cur[1]);
        	if (cur[2] == nums.length - 1) continue;
        	pq.offer(new int[] {cur[0], nums[cur[2] + 1], cur[2] + 1});
        }
        return 0;
    }
	
	/*public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int diffIndex = 1;
        int numDiff = n - 1;
        while(k > numDiff) {
        	k -= numDiff;
        	numDiff--;
        	diffIndex++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((x, y) -> y - x);
        for (int i = 0; i + diffIndex < n; i++) {
        	int diff = nums[i + diffIndex] - nums[i];
        	if (pq.size() < k) pq.offer(diff);
        	else {
        		if (pq.peek() > diff) {
        			pq.poll();
        			pq.offer(diff);
        		}
        	}
        }
        while(k > 1) {
        	pq.poll();
        	k--;
        }
        return pq.peek();
    }*/
	
	public static void main(String[] args) {
		Prob719 prob = new Prob719();
		//System.out.println(prob.smallestDistancePair(new int[] {62, 100, 4}, 2));
		System.out.println(prob.smallestDistancePair(new int[] {9,10,7,10,6,1,5,4,9,8}, 18));
	}
}
