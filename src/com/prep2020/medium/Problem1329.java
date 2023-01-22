package com.prep2020.medium;
import java.util.*;
public class Problem1329 {
	public int[][] diagonalSort(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        for (int i = 0; i < n; i++) {
        	int j = 0, k = i;
        	List<Integer> list = new ArrayList<>();
        	while(j < m && k < n) {
        		list.add(mat[j++][k++]);
        	}
        	Collections.sort(list);
        	j = 0; k = i;
        	for (int x = 0; x < list.size(); x++) {
        		mat[j++][k++] = list.get(x);
        	}
        }
        for (int i = 1; i < m; i++) {
        	int j = i, k = 0;
        	List<Integer> list = new ArrayList<>();
        	while(j < m && k < n) {
        		list.add(mat[j++][k++]);
        	}
        	Collections.sort(list);
        	j = i; k = 0;
        	for (int x = 0; x < list.size(); x++) {
        		mat[j++][k++] = list.get(x);
        	}
        }
        return mat;
    }
}
