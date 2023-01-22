package com.prep2020.medium;
import java.util.*;
public class Problem1428 {
	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int result = -1;
        List<Integer> dim = binaryMatrix.dimensions();
        int low = 0, high = dim.get(1) - 1;
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i < dim.get(0); i++) rows.add(i);
        while (low <= high) {
        	int mid = low + (high - low) / 2;
        	List<Integer> temp = new ArrayList<>();
        	for (int r : rows) {
        		if (binaryMatrix.get(r, mid) == 1) {
        			result = mid;
        			temp.add(r);
        		}
        	}
        	if (result == mid) {
        		high = mid - 1;
        		rows = temp;
        	} else low = mid + 1;
        }
        return result;
    }
	
	interface BinaryMatrix {
		      public int get(int row, int col);
		      public List<Integer> dimensions();
		  }
}
