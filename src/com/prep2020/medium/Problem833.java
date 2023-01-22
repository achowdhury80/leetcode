package com.prep2020.medium;
import java.util.*;
public class Problem833 {
	/**
	 * O(N + klogK) 
	 * @param s
	 * @param indices
	 * @param sources
	 * @param targets
	 * @return
	 */
	public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int n = s.length();
        Queue<Integer> q = new PriorityQueue<>((x, y) -> indices[x] - indices[y]);
        for (int i = 0; i < indices.length; i++) q.offer(i);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
        	if (q.isEmpty() || i < indices[q.peek()]) sb.append(s.charAt(i));
        	else {
        		int idx = q.poll();
        		if (s.indexOf(sources[idx], indices[idx]) == indices[idx]) {
        			sb.append(targets[idx]);
        			i = indices[idx] + sources[idx].length() - 1;
        		} else {
        			sb.append(s.charAt(i));
        		}
        	}
        }
        return sb.toString();
    }
	
	public static void main(String[] args) {
		Problem833 problem = new Problem833();
		/*System.out.println(problem.findReplaceString("abcd",
				new int[] {0, 2},
				new String[] {"a", "cd"},
				new String[] {"eee", "ffff"})); */
		System.out.println(problem.findReplaceString("abcd",
				new int[] {0, 2},
				new String[] {"ab", "ec"},
				new String[] {"eee", "ffff"}));
	}
}
