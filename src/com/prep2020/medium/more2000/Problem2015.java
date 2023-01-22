package com.prep2020.medium.more2000;
import java.util.*;
public class Problem2015 {
	public int[][] averageHeightOfBuildings(int[][] buildings) {
        List<int[]> list = new ArrayList<>();
        Queue<int[]> pq = new PriorityQueue<>((x, y) -> (x[0] == y[0] ? (y[1] - x[1]) 
        		: (x[0] - y[0])));
        for (int[] b : buildings) {
        	pq.offer(new int[] {b[0], 0, b[2]});
        	pq.offer(new int[] {b[1], 1, b[2]});
        }
        int open = 0, sum = 0, start = -1;
        while(!pq.isEmpty()) {
        	int[] cur = pq.poll();
        	if (cur[1] == 1) {
        		addToList(list, new int[] {start, cur[0], sum / open});
        		open--;
        		sum -= cur[2];
        		start = cur[0];
        	} else {
        		if (open > 0 && cur[0] > start) addToList(list, 
        				new int[] {start, cur[0], sum / open});
        		open++;
        		sum += cur[2];
        		start = cur[0];
        	}
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i);
        return result;
    }
	
	private void addToList(List<int[]> list, int[] arr) {
		if (list.isEmpty()) {
			list.add(arr);
			return;
		}
		int[] last = list.get(list.size() - 1);
		if (last[2] == arr[2] && last[1] == arr[0]) last[1] = arr[1];
		else if (last[1] == arr[1]) return;
		else list.add(arr);
	}
	
	public static void main(String[] args) {
		Problem2015 problem = new Problem2015();
		System.out.println(problem.averageHeightOfBuildings(new int[][]{{1,2,1},{1,2,3},
			{1,2,2}}));
	}
}
