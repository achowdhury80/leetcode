package com.prep2020.hard;
import java.util.*;
public class Problem1606 {
	public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[][] servers = new int[k][2];
        List<Integer> available = new ArrayList<>();
        for (int i = 0; i < k; i++) available.add(i);
        Queue<Integer> busy = new PriorityQueue<>((x, y) -> servers[x][0] - servers[y][0]);
        for (int i = 0; i < load.length; i++) {
        	while(!busy.isEmpty() && servers[busy.peek()][0] <= arrival[i]) {
        		int serverToAdd = busy.poll();
        		int idx = Collections.binarySearch(available, serverToAdd);
        		idx = -(idx + 1);
        		available.add(idx, serverToAdd);
        	}
        	if (available.isEmpty()) continue;
        	int curServer = i % k;
        	int idx = Collections.binarySearch(available, curServer);
        	if (idx < 0) idx = -(idx + 1);
        	if (idx == available.size()) idx = 0;
    		int target = available.remove(idx);
    		servers[target][0] = arrival[i] + load[i];
    		servers[target][1]++;
    		busy.offer(target);
        }
        int maxReq = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
        	if (servers[i][1] > maxReq) {
        		maxReq = servers[i][1];
        		result.clear();
        		result.add(i);
        	} else if (servers[i][1] == maxReq) result.add(i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem1606 problem = new Problem1606();
		System.out.println(problem.busiestServers(3, new int[] {1,2,3,4,5}, new int[] {5,2,3,3,3}));
	}
}
