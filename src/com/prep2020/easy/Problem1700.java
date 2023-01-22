package com.prep2020.easy;

public class Problem1700 {
	/**
	 * O(N)
	 * @param students
	 * @param sandwiches
	 * @return
	 */
	public int countStudents(int[] students, int[] sandwiches) {
        int[] arr = new int[2];
        for (int s : students) arr[s]++;
        for (int i = 0; i < sandwiches.length; i++) {
        	if (arr[sandwiches[i]] > 0) arr[sandwiches[i]]--;
        	else return sandwiches.length - i;
        }
        return 0;
    }
}
