package com.prep2020.medium;

public class Problem1234 {
	public int balancedString(String s) {
        String st = "QWER";
        int minCount = s.length() / 4;
        if (minCount == 0) return 0;
        int[] arr = new int[4];
        for (char c : s.toCharArray()) {
        	arr[st.indexOf(c)]++;
        }
        
        for (int i = 0; i < 4; i++) {
        	if (arr[i] <= minCount) arr[i] = Integer.MIN_VALUE;
        	else arr[i] -= minCount;
        }
        int count = 0;
        for (int i : arr) if (i > 0) count += i;
        if (count == 0) return 0;
        int start = 0, result = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
        	int idx = st.indexOf(s.charAt(i));
        	if (arr[idx] != Integer.MIN_VALUE) {
        		arr[idx]--;
        		if (arr[idx] > -1) count--;
        		while(count == 0 && start < s.length()) {
            		result = Math.min(result, i - start + 1);
            		idx = st.indexOf(s.charAt(start++));
            		if (arr[idx] != Integer.MIN_VALUE) {
            			arr[idx]++;
            			if (arr[idx] > 0) count++;
            		}
            	}
        	}
        }
        
        return result;
    }
	
	public static void main(String[] args) {
		Problem1234 problem = new Problem1234();
		System.out.println(problem.balancedString("QQWE"));
	}
}
