package com.leet.algo;
import java.util.*;
public class Prob774 {
	/**
	 * https://leetcode.com/problems/minimize-max-distance-to-gas-station/discuss/320839/Thoughts-and-Lessons-from-the-Max-Heap-Solution
	 * @param stations
	 * @param K
	 * @return
	 */
	public double minmaxGasDist(int[] stations, int K) {
		int n = stations.length;
        Queue<double[]> pq = new PriorityQueue<>((x, y) -> x[0] / x[1] > y[0] / y[1] ? -1 : 1);
        double[] cur = null;
        double upperBound = (stations[n - 1] - stations[0] + 0.0) / K + 1;
        int added = 0;
        // at the beginning put as many stations as possible within the bigger distances
        for (int i = 1; i < n; i++) {
        	int needed = (int)Math.ceil((stations[i] - stations[i - 1]) / upperBound) - 1;
        	pq.offer(new double[]{stations[i] - stations[i - 1], needed + 1.0});
        	added += needed;
        }
        while(added < K) {
        	cur = pq.poll();
        	cur[1] += 1;
        	pq.offer(cur);
        	added++;
        }
        cur = pq.poll();
        return cur[0]/cur[1];
    }
	
	public static void main(String[] args) {
		Prob774 prob = new Prob774();
		System.out.println(prob.minmaxGasDist(new int[] {1,2,3,4,5,6,7,8,9,10}, 9));
	}
}
