package com.prep2020.medium;

import java.util.Arrays;

public class Problem881 {
	/**
	 * O(nlogn)
	 * @param people
	 * @param limit
	 * @return
	 */
	public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, result = 0;
        while(i <= j) {
        	result++;
        	if (i == j) break;
        	else if (people[i] + people[j] <= limit) {
        		i++;
        		j--;
        	} else j--;
        }
        return result;
    }
}
