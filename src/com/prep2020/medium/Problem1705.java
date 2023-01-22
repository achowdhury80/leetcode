package com.prep2020.medium;
import java.util.*;
public class Problem1705 {
	public int eatenApples(int[] apples, int[] days) {
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        int result = 0;
        for (int i = 0; i < apples.length || !pq.isEmpty(); i++) {
        	if (i < apples.length && apples[i] != 0) 
        		pq.offer(new int[] {apples[i], i + days[i]});
        	while(!pq.isEmpty() && pq.peek()[1] <= i) pq.poll();
        	if (!pq.isEmpty()) {
        		int[] arr = pq.poll();
        		result++;
        		arr[0]--;
        		if (arr[0] > 0) pq.offer(arr);
        	}
        }
        return result;
    }
}
