package com.prep2020.hard;

public class Problem1601 {
	/**
	 * O(2^N)
	 * @param n
	 * @param requests
	 * @return
	 */
	public int maximumRequests(int n, int[][] requests) {
        int[] result = new int[1];
        int[] netChange = new int[n];
        helper(requests, 0, 0, netChange, result);
        return result[0];
    }
	
	private void helper(int[][] reqs, int start, int requests, int[] netChange, int[] result) {
		boolean flag = true;
		for (int i : netChange) {
			if (i != 0) {
				flag = false;
				break;
			}
		}
		if (flag) result[0] = Math.max(result[0], requests);
		if (start == reqs.length) return;
		netChange[reqs[start][0]]--;
		netChange[reqs[start][1]]++;
		helper(reqs, start + 1, requests + 1, netChange, result);
		netChange[reqs[start][0]]++;
		netChange[reqs[start][1]]--;
		helper(reqs, start + 1, requests, netChange, result);
		
	}
}
