package com.leet.algo;
import java.util.*;
public class Prob986 {
	public int[][] intervalIntersection(int[][] A, int[][] B) {
        List<int[]> list = new ArrayList<>();
        int a = 0, b = 0;
        while(a < A.length && b < B.length) {
        	int[] aInterval = A[a];
        	int[] bInterval = B[b];
        	if (aInterval[1] < bInterval[0]) a++;
        	else if (bInterval[1] < aInterval[0]) b++;
        	else {
        		list.add(new int[] {Math.max(aInterval[0], bInterval[0]), Math.min(aInterval[1], bInterval[1])});
        		if (aInterval[1] == bInterval[1]) {
        			a++;
        			b++;
        		} else if (aInterval[1] < bInterval[1]) {
        			a++;
        		} else b++;
        	}
        }
        int[][] result = new int[list.size()][];
        for (int i = 0; i < list.size(); i++) result[i] = list.get(i); 
        return result;
    }
}
