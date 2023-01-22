package com.prep2020.easy;

public class Problem1103 {
	/**
	 * O(N)
	 * @param candies
	 * @param num_people
	 * @return
	 */
	public int[] distributeCandies(int candies, int num_people) {
		int[] result = new int[num_people];
        int i = 0, sum = 0, count = 1;
        while(sum + count < candies) {
        	sum += count;
        	result[i] += count;
        	i = (i + 1) % num_people;
        	count++;
        }
        result[i] += candies - sum;
        return result;
    }
}
