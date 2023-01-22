package com.prep2020.hard;

import java.util.*;

public class Problem2386 {
	/*
    Thanks for Huifeng Guan 's explanation. ref : https://www.youtube.com/watch?v=pquoywwK0_w 
    1. the largest Sum is the sum of all no negative numbers.
    2. to get the next largest sum we can remove a no negative number (- nogegative) 
    or add a negative number (- abs(negative)).
    3. the problem turn to (the largest sum) - (the k-th smallest sum of sequence of a nonegative array)
    4. to get the K smallest sum
       eg. 
       index:   0, 1, 2, 3
       arr:    [1, 2, 3, 4]
       the smallest is 1 then 2, 1+2 could be the second smallest.
       to get the k smallest sum, please see the following binary tree, 
	   a. the value of the node is the sum of elements in this node.
       b. we use the 0-th element as the root. 
       c. the left child: remove the parent last number + the next number
       d. the right child: keep the parent + the next number
       e. the children are always greater than or equal to (if there are duplicates) its parent. 
	   because the left child use a greater number (the next number) take the place of the 
	   last number in the parent. and the right child add an extra number (the next number)
                               1 
                  2                         1+2
            3          2+3             1+3          1+2+3
          4  3+4     2+4  2+3+4     1+4  1+3+4   1+2+4    1+2+3+4
*/
	public long kSum(int[] nums, int k) {
		int n = nums.length;
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
        	if (nums[i] > 0) maxSum += nums[i];
        	else nums[i] = -nums[i];
        }
        Arrays.sort(nums);
        if (k == 1) return maxSum;
        Queue<long[]> pq = new PriorityQueue<>((x, y) -> Long.compare(x[0], y[0]));
        pq.offer(new long[] {nums[0], 0l});
        while(k-- > 1) {
        	long[] s = pq.poll();
        	if (k == 1) return maxSum - s[0];
        	if (s[1] + 1 < n) {
        		pq.offer(new long[] {s[0] + nums[(int)(s[1] + 1)] - nums[(int)s[1]], s[1] + 1});
        		pq.offer(new long[] {s[0] + nums[(int)(s[1] + 1)], s[1] + 1});
        	}
        }
        return Long.MAX_VALUE;
    }
}
