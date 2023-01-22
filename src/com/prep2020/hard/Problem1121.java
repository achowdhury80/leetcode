package com.prep2020.hard;
import java.util.*;
public class Problem1121 {
	/**
	 * if f = max freq, then O(NFlogF)
	 * number of groups(g) = max freq of a number
	 * add g list to a priority queue;
	 * keep adding next num to the smallest list if possible
	 * @param nums
	 * @param k
	 * @return
	 */
	public boolean canDivideIntoSubsequences(int[] nums, int k) {
		if (k == 1) return true;
		int prev = -1, count = 0, max = 1;
		for (int num : nums) {
			if (prev == num) {
				count++;
				max = Math.max(max, count);
			} else count = 1;
			prev = num;
		}
        Queue<List<Integer>> pq = new PriorityQueue<>((x, y) -> x.size() - y.size());
        for (int i = 0; i < max; i++) pq.offer(new ArrayList<>());
        for (int num : nums) {
        	if (!addToExisting(pq, num)) return false;
        }
        
        return pq.peek().size() >= k;
    }

	private boolean addToExisting(Queue<List<Integer>> pq, int num) {
		boolean added = false;
		List<List<Integer>> temp = new ArrayList<>();
		while(!pq.isEmpty()) {
			List<Integer> list = pq.poll();
			temp.add(list);
			if (list.isEmpty() || list.get(list.size() - 1) < num) {
				list.add(num);
				added = true;
				break;
			}
		}
		pq.addAll(temp);
		return added;
	}
	
	/**
	 * Note that since the subs should be increasing, we can't have one number more than once in one group. So, the number of groups would be max frequency of any digit. for example, for 1,2,2,2,2,2,3, the number of groups should be 5 since the frequncy of 2 is 5. Since each group should have at least K elements, the total number of elements should be greater than or equals:
numOfGroups * K

    public boolean canDivideIntoSubsequences(int[] nums, int K) {
        int groupsCount = 0;
        int localCount = 0;
        int prev = -1; // Prev init is -1 since elements are positive
        for (int num : nums) {
            localCount = prev == num ? localCount + 1 : 1; // If equals prev num, increase the local count
            groupsCount = Math.max(groupsCount, localCount); // update the max group size
            prev = num;
        }
        return nums.length >= groupsCount * K; // Check if the number of elements are greater than num of groups X K (min size)
    }
	 */
}
