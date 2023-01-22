package com.prep2020.medium;
import java.util.*;
public class Problem433 {
	public int minMutation(String start, String end, String[] bank) {
        Set<String> available = new HashSet<>();
        for (String s : bank) available.add(s);
        available.remove(start);
        if (!available.contains(end)) return -1;
        if (start.equals(end)) return 0;
        int result = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		String cur = q.poll();
        		List<String> nexts = findNexts(cur, available);
        		for (String s : nexts) {
        			if (s.equals(end)) return result;
        			available.remove(s);
        			q.offer(s);
        		}
        	}
        }
        return -1;
    }

	private List<String> findNexts(String cur, Set<String> available) {
		String chars = "ACGT";
		List<String> nexts = new ArrayList<>();
		for (String a : available) {
			if (exactOneDiff(a, cur)) {
				nexts.add(a);
			}
		}
		available.removeAll(nexts);
		return nexts;
	}
	
	private boolean exactOneDiff(String a, String cur) {
		int diff = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != cur.charAt(i)) {
				diff++;
				if (diff > 1) return false;
			}
		}
		return diff == 1;
	}

	public static void main(String[] args) {
		Problem433 problem = new Problem433();
		System.out.println(problem.minMutation("AACCGGTT",
				"AACCGGTA",
				new String[]{"AACCGGTA"}));
	}
}
