package com.leet.algo;

import java.util.Arrays;

public class Prob881 {
	public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i = 0, j = people.length - 1, result = 0;
        while(i < j) {
        	if (people[i] + people[j] <= limit) i++;
        	j--;
        	result++;
        }
        if (i == j) result++;
        return result;
    }
}
