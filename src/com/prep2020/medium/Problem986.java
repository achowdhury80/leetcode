package com.prep2020.medium;
import java.util.*;
public class Problem986 {
	/**
	 * O(N)
	 * @param firstList
	 * @param secondList
	 * @return
	 */
	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while(i < firstList.length && j < secondList.length) {
        	if (firstList[i][1] < secondList[j][0]) i++;
        	else if (firstList[i][0] > secondList[j][1]) j++;
        	else {
        		list.add(new int[] {Math.max(firstList[i][0], secondList[j][0]), 
        				Math.min(firstList[i][1], secondList[j][1])});
        		if (firstList[i][1] > secondList[j][1]) j++;
        		else if (firstList[i][1] < secondList[j][1]) i++;
        		else {
	        		i++;
	        		j++;
        		}
        	}
        }
        int[][] result = new int[list.size()][];
        for (int k = 0; k < list.size(); k++) result[k] = list.get(k);
        return result;
    }
}
