package com.leet.algo;
import java.util.*;
public class Prob1042 {
	public int[] gardenNoAdj(int N, int[][] paths) {
		
        int[] ans = new int[N];
        List<Integer>[] arr = new List[N];
        for (int[] path : paths) {
        	if (arr[path[0] - 1] == null) arr[path[0] - 1] = new ArrayList<>();
        	if (arr[path[1] - 1] == null) arr[path[1] - 1] = new ArrayList<>();
        	arr[path[0] - 1].add(path[1] - 1);
        	arr[path[1] - 1].add(path[0] - 1);
        }
        for (int i = 1; i <= N; i++) {
        	List<Integer> list = arr[i - 1];
        	if (list == null) {
        		ans[i - 1] = 1;
        		continue;
        	}
        	boolean[] color = new boolean[4];
        	for (int g : list) {
        		if (ans[g] != 0) color[ans[g] - 1] = true;
        	}
        	for (int j = 0; j < 4; j++) {
        		if (!color[j]) {
        			ans[i - 1] = j + 1;
        			break;
        		}
        	}
        }
        return ans;
    }
}
