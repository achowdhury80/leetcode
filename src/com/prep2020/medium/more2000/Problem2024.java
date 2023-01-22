package com.prep2020.medium.more2000;

public class Problem2024 {
	/**
	 * O(N)
	 * @param answerKey
	 * @param k
	 * @return
	 */
	public int maxConsecutiveAnswers(String answerKey, int k) {
        int result = 0, start = 0, n = answerKey.length();
        int[] arr = new int[2];
        for (int i = 0; i < n; i++) {
        	char c = answerKey.charAt(i);
        	if (c == 'T') arr[0]++;
        	else arr[1]++;
        	while(Math.min(arr[0], arr[1]) > k) {
        		char c1 = answerKey.charAt(start);
        		if (c1 == 'T') arr[0]--;
        		else arr[1]--;
        		start++;
        	}
        	result = Math.max(result, i - start + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Problem2024 problem = new Problem2024();
		System.out.println(problem.maxConsecutiveAnswers("TFFT", 1));
	}
}
