package com.prep2020.medium;
import java.util.*;
public class Problem1882 {
	public int[] assignTasks(int[] servers, int[] tasks) {
        Queue<Integer> availableServers = new PriorityQueue<>(
        		(x, y) -> servers[x] != servers[y] 
        				? (servers[x] - servers[y]) : (x - y));
        Queue<int[]> busyServers = new PriorityQueue<>((x, y) -> x[1] - y[1]);
        for (int i = 0; i < servers.length; i++) availableServers.offer(i);
        int n = tasks.length;
        int[] result = new int[n];
        int curTime = 0;
        for (int i = 0; i < n; i++) {
        	curTime = Math.max(curTime, i);
        	while(!busyServers.isEmpty() && busyServers.peek()[1] <= curTime) {
        		availableServers.offer(busyServers.poll()[0]);
        	}
        	if(availableServers.isEmpty()) {
        		curTime = busyServers.peek()[1];
        		i--;
        		continue;
        	}
        	
        	int server = availableServers.poll();
        	result[i] = server;
        	busyServers.offer(new int[] {server, curTime + tasks[i]});
        }
        return result;
    }
}
