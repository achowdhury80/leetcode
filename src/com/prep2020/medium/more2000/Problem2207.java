package com.prep2020.medium.more2000;

public class Problem2207 {
	public long maximumSubsequenceCount(String text, String pattern) {
        char c1 = pattern.charAt(0), c2 = pattern.charAt(1);
        char[] arr = text.toCharArray();
        long firstCount = 0, secondCount = 0;
        if (c1 == c2) {
        	for (char c : arr) {
        		if (c == c1) firstCount++;
        	}
        	return ((firstCount + 1l) * firstCount)/ 2;
        }
        
        long result = 0;
        // adding b at the end
        secondCount = 1;
        for (int i = arr.length - 1; i > -1; i--) {
        	char c = arr[i];
        	if (c == c1) result += secondCount;
        	else if (c == c2) secondCount++;
        }
        
        // adding a at the front
        firstCount = 1;
        long curCount = 0;
        for (char c : arr) {
        	if (c == c1) firstCount++;
        	else if (c == c2) curCount += firstCount;
        }
        
        return Math.max(result, curCount);
    }
	
	public static void main(String[] args) {
		Problem2207 problem = new Problem2207();
		System.out.println(problem.maximumSubsequenceCount("mzyzmhrbgfvtkryzpqoacbwtdpri","ty"));
	}
}
