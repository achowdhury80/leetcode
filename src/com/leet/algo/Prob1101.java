package com.leet.algo;
import java.util.*;
public class Prob1101 {
	public int earliestAcq(int[][] logs, int N) {
        int[][] arr = new int[N][2];
        for (int i = 0; i < arr.length; i++) arr[i] = new int[] {i, 1};
        Arrays.sort(logs, (a,b) -> a[0] - b[0]);
        for (int[] log : logs) {
        	int[] p1 = findParent(arr, log[1]);
        	int[] p2 = findParent(arr, log[2]);
        	if (union(arr, p1[0], p2[0]) >= N) return log[0];
        }
        return -1;
    }
	
	private int[] findParent(int[][] arr, int i) {
		while(arr[i][0] != i) i = arr[i][0];
		return arr[i];
	}
	
	private int union(int[][] arr, int p1, int p2) {
		if(p1 == p2) return arr[p1][1];
		if (arr[p1][1] >=  arr[p2][1]) {
			arr[p2][0] = p1;
			arr[p1][1] += arr[p2][1];
			return arr[p1][1];
		} else {
			arr[p1][0] = p2;
			arr[p2][1] += arr[p1][1];
			return arr[p2][1];
		}
	}
}
