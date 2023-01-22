package com.prep2020.medium;
import java.util.*;
public class Problem1023 {
	/**
	 * O(N*K)
	 * @param queries
	 * @param pattern
	 * @return
	 */
	public List<Boolean> camelMatch(String[] queries, String pattern) {
		List<Boolean> result = new ArrayList<>();
		for (String q : queries) {
			int j = 0;
			boolean flag = true;
			for (int i = 0; i < q.length(); i++) {
				char c1 = q.charAt(i);
				if (j < pattern.length()) {
					char c2 = pattern.charAt(j);
					if (c1 == c2) j++;
					else if (!Character.isLowerCase(c1)) {
						flag = false;
						break;
					}
				} else {
					if (!Character.isLowerCase(c1)) {
						flag = false;
						break;
					}
				}
			}
			if (!flag || j < pattern.length()) result.add(false);
			else result.add(true);
		}
		return result;
    }
	
	public static void main(String[] args) {
		Problem1023 problem = new Problem1023();
		System.out.println(problem.camelMatch(new String[] {"FooBar","FooBarTest","FootBall","FrameBuffer",
				"ForceFeedBack"}, "FB"));
	}
}
