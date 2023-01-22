package com.prep2020.medium;
import java.util.*;
public class Problem1985 {
	public String kthLargestNumber(String[] nums, int k) {
		Queue<String> pq = new PriorityQueue<>((a, b) -> compare(a, b));
		for (String num : nums) {
			pq.offer(num);
			if (pq.size() > k) pq.poll();
		}
		return pq.poll();
    }
	
	private int compare(String s1, String s2) {
		if (s1.length() > s2.length()) return 1;
		if (s1.length() < s2.length()) return -1;
		return s1.compareTo(s2);
	}
	
	public static void main(String[] args) {
		Problem1985 problem = new Problem1985();
		/*System.out.println(problem.kthLargestNumber(new String[] {
				"3","6","7","10"}, 4));*/
		/*System.out.println(problem.kthLargestNumber(new String[] {
				"2","21","12","1"}, 3));*/
		
		System.out.println(problem.kthLargestNumber(new String[] {
				"8433","522","2","42"}, 4));
	}
}
