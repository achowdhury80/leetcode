package com.prep2020.medium;

public class Problem1663 {
	public String getSmallestString(int n, int k) {
        char[] result = new char[n];
        for (int position = 0; position < n - 1; position++) {
        	int remainingPos = n - position - 1;
        	int valToBeAddedLater = remainingPos * 26;
        	int cur = (k - valToBeAddedLater) <= 0 ? 1 : (k - valToBeAddedLater);
        	k -= cur;
        	result[position] = (char)((cur - 1) + 'a');
        }
        result[n - 1] = (char)((k - 1) + 'a');
        return new String(result);
    }
	
	public String getSmallestString1(int n, int k) {
        char[] result = new char[n];
        for (int position = n - 1; position >= 0; position--) {
            int add = Math.min(k - position, 26);
            result[position] = (char) (add + 'a' - 1);
            k -= add;
        }
        return new String(result);
    }
	
	public static void main(String[] args) {
		Problem1663 problem = new Problem1663();
		System.out.println(problem.getSmallestString(3, 27));
	}
}
