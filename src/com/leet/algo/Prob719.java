package com.leet.algo;

import java.util.*;

public class Prob719 {
	
	/**
	 * o(nlogn)
	 * @param nums
	 * @param k
	 * @return
	 */
	public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = nums[nums.length - 1];
        while(l < r) {
        	int mid = l + (r - l) / 2;
        	int c = countDiffLessEqualX(nums, mid);
        	// let say r = r1 where c = k.
        	// that does not mean the diff r1 is present in the array
        	// l moves 1 at a time
        	// which will ensure if r1 is not present and r1 -1 is present then 
        	//we get r1 - 1
        	if (c >= k) r = mid;
        	else l = mid + 1;
        }
        return l;
    }
	
	/**
	 * O(N)
	 * finds the count of diff <= x
	 * @param nums
	 * @param x
	 * @return
	 */
	private int countDiffLessEqualX(int[] nums, int x) {
		int l = 0, r = nums.length - 1;
		int result = 0;
		for (r = l + 1; r < nums.length; r++) {
			while(nums[r] - nums[l] > x) l++;
			result += r - l;
		}
		return result;
	}
	
	/*public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> 
        (Math.abs(x[0] - x[1]) - Math.abs(y[0] - y[1])));
        for (int i = 0; i < nums.length - 1; i++) pq.offer(new int[] {nums[i], 
        nums[i + 1], i + 1});
        int index = 0;
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if(++index == k) return Math.abs(cur[0] - cur[1]);
        	if (cur[2] == nums.length - 1) continue;
        	pq.offer(new int[] {cur[0], nums[cur[2] + 1], cur[2] + 1});
        }
        return 0;
    }*/
	
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
		System.out.println(prob.smallestDistancePair(new int[] {
				9,10,7,10,6,1,5,4,9,8}, 18));
	}
}
