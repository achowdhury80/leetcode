package com.prep2020.medium;
import java.util.*;
public class Problem544 {
	/**
	 * O(NlogN) time and O(N) space
	 * @param n
	 * @return
	 */
	public String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add("" + i);
        while(list.size() > 1) {
        	List<String> temp = new ArrayList<>();
        	int i = 0, j = list.size() - 1;
        	while(i < j) {
        		temp.add("(" + list.get(i) + "," + list.get(j) + ")");
        		i++;
        		j--;
        	}
        	list = temp;
        }
        return list.get(0);
    }
}
