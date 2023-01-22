package com.prep2020.hard;
import java.util.*;
public class Problem2151 {
	public int maximumGood(int[][] statements) {
        int n = statements.length, result = 0;
        for (int i = 1; i < (1 << n); i++) {
        	if (isValid(statements, i)) result = Math.max(result, Integer.bitCount(i));
        }
        return result;
    }

	private boolean isValid(int[][] statements, int cur) {
		int n = statements.length;
		for (int i = 0; i < n; i++) {
			if ((cur & (1 << i)) == 0) continue;
			for (int j = 0; j < n; j++) {
				if (statements[i][j] == 2) continue;
				if (statements[i][j] != ((cur & (1 << j)) == 0 ? 0 : 1)) return false; 
			}
		}
		return true;
	}
	
	
}
