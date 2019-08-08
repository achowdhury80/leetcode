package com.leet.algo;
import java.util.*;
public class Problem909 {
	public int snakesAndLadders(int[][] board) {
		int n = board.length;
        int[] arr = new int[n * n + 1];
        int[] pos = new int[] {n - 1, 0};
        boolean asc = true;
        for (int i = 1; i < arr.length; i++) {
        	arr[i] = board[pos[0]][pos[1]];
        	if (asc) {
        		if (i % n == 0) {
        			pos[0]--;
        			asc = false;
        		} else pos[1]++;
        	} else {
        		if (i % n == 0) {
        			pos[0]--;
        			asc = true;
        		} else pos[1]--;
        	}
        }
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> seen = new HashSet<>();
        q.add(1);
        seen.add(1);
        int result = 0;
        while(!q.isEmpty()) {
        	int size = q.size();
        	result++;
        	for (int i = 0; i < size; i++) {
        		int num = q.poll();
        		for (int j = 1; j < 7; j++) {
        			int next = num + j;
        			if (next <= n * n && arr[next] != -1) next = arr[next];
        			if (!seen.contains(next)) {
        				if (next == n * n) return result;
        				q.offer(next);
        			}
        		}
        	}
        }
        return -1;
    }
}
