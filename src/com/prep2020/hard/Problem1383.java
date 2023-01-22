package com.prep2020.hard;
import java.util.*;
public class Problem1383 {
	public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int mod = (int) (1e9 + 7);
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) arr[i] = i;
        Arrays.sort(arr, (x, y) -> efficiency[y] - efficiency[x]);
        // create a heap to keep the top (k-1) speeds
        PriorityQueue<Integer> speedHeap = new PriorityQueue<>((o1, o2) -> o1 - o2);

        long speedSum = 0, perf = 0;
        for (int i : arr) {
            Integer currEfficiency = efficiency[i];
            Integer currSpeed = speed[i];
            // maintain a heap for the fastest (k-1) speeds
            if (speedHeap.size() > k - 1) {
                speedSum -= speedHeap.remove();
            }
            speedHeap.add(currSpeed);

            // calculate the maximum performance with
            // the current member as the least efficient one in the team
            speedSum += currSpeed;
            perf = Math.max(perf, speedSum * currEfficiency);
        }
        return (int) (perf % mod);
    }
}
