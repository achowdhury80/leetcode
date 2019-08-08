package com.leet.algo;
import java.util.*;
public class Prob1020 {
	public int numEnclaves(int[][] A) {
		Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < A[0].length; i++) {
        	if (A[0][i] == 1) {
        		A[0][i] = -1;
        		q.offer(new int[] {0, i});
        	}
        	if (A[A.length - 1][i] == 1) {
        		A[A.length - 1][i] = -1;
        		q.offer(new int[] {A.length - 1, i});
        	}
        }
        for (int i = 1; i < A.length - 1; i++) {
        	if (A[i][0] == 1) {
        		A[i][0] = -1;
        		q.offer(new int[] {i, 0});
        	}
        	if (A[i][A[0].length - 1] == 1) {
        		A[i][A[0].length - 1] = -1;
        		q.offer(new int[] {i, A[0].length - 1});
        	}
        }
        while(!q.isEmpty()) {
        	int[] xy = q.poll();
        	List<int[]> neighbor = findLandNeighbor(xy, A);
        	for (int[] ab : neighbor) {
        		A[ab[0]][ab[1]] = -1;
        		q.offer(ab);
        	}
        }
        
        int result = 0;
        for (int i = 0; i < A.length; i++) {
        	for (int j = 0; j < A[0].length; j++) {
        		if (A[i][j] == 1) result++;
        		if (A[i][j] == -1) A[i][j] = 1;
        	}
        }
        return result;
    }
	
	private List<int[]> findLandNeighbor(int[] xy, int[][] A) {
		List<int[]> neighbor = new ArrayList<>();
		if (xy[0] + 1 < A.length && A[xy[0] + 1][xy[1]] == 1) 
			neighbor.add(new int[] {xy[0] + 1, xy[1]});
		if (xy[0] - 1 > -1 && A[xy[0] - 1][xy[1]] == 1) 
			neighbor.add(new int[] {xy[0] - 1, xy[1]});
		if (xy[1] + 1 < A[0].length && A[xy[0]][xy[1] + 1] == 1) 
			neighbor.add(new int[] {xy[0], xy[1] + 1});
		if (xy[1] - 1 > -1 && A[xy[0]][xy[1] - 1] == 1) 
			neighbor.add(new int[] {xy[0], xy[1] - 1});
		return neighbor;
	}
}
