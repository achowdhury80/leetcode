package com.leet.algo;

public class Prob1103 {
	public int[] distributeCandies(int candies, int num_people) {
        int[] result = new int[num_people];
        int sum = 0, j = 0, i = 0;
        for (i = 1; sum + i <= candies;i++) {
        	result[j % num_people] += i;
        	sum += i;
        	j++;
        }
        if (sum < candies) {
        	result[j % num_people] += candies - sum;
        }
        return result;
    }
}
