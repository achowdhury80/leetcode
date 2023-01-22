package com.prep2020.hard;
import java.util.*;
public class Problem765 {
	public int minSwapsCouples1(int[] row) {
        int result = 0;
        for (int i = 0; i < row.length; i += 2) {
        	if (row[i + 1] == (row[i] ^ 1)) continue;
        	for (int j = i + 2; j < row.length; j++) {
        		if (row[i] == (row[j] ^ 1)) {
        			row[j] = row[i + 1];
        			row[i + 1] = row[i] ^ 1;
        			result++;
        			break;
        		}
        	}
        }
        return result;
    }
}
