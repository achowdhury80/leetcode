package com.prep2020.medium;
import java.util.*;
public class Problem247 {
	/**
	 * O(5^n)
	 * @param n
	 * @return
	 */
	public List<String> findStrobogrammatic(int n) {
		List<String> result = new ArrayList<>();
		if (n < 1) return result;
		Map<String, String> map = new HashMap<>();
		map.put("6", "9");
		map.put("9", "6");
		List<String> same = Arrays.asList("0", "1", "8");
		if (n % 2 == 1) {
			result.addAll(same);
			n--;
		}
		n /= 2;
		
		for (int i = 0; i < n; i++) {
			List<String> temp = new ArrayList<>();
			for (Map.Entry<String, String> entry : map.entrySet()) {
				if (result.isEmpty()) {
					temp.add(entry.getKey() + entry.getValue());
				} else {
					for (String s : result) {
						temp.add(entry.getKey() + s + entry.getValue());
					}
				}
			}
			for (String s : same) {
				if (i == n - 1 && s.equals("0")) continue;
				if (result.isEmpty()) {
					temp.add(s + s);
				} else {
					for (String val : result) {
						temp.add(s + val + s);
					}
				}
			}
			result = temp;
		}
		return result;
    }
	
	public static void main(String[] args) {
		Problem247 problem = new Problem247();
		System.out.println(problem.findStrobogrammatic(2));
	}
}
