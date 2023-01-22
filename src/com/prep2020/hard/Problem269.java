package com.prep2020.hard;
import java.util.*;

public class Problem269 {
	public String alienOrder(String[] words) {
        int[] indeg = new int[26];
        for (int i = 0; i < 26; i++) indeg[i] = -1;
        for (String w : words) {
        	for (char c : w.toCharArray()) indeg[c - 'a'] = 0;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) if (indeg[i] == 0) count++;
        Set<Integer>[] nexts = new Set[26];
        for (int i = 0; i < 26; i++) nexts[i] = new HashSet<>();
        char c1, c2;
        for (int i = 1; i < words.length; i++) {
        	if (words[i - 1].length() > words[i].length() && words[i - 1].startsWith(words[i])) return "";
        	for (int j = 0; j < Math.min(words[i - 1].length(), words[i].length()); j++) {
        		if ((c1 = words[i - 1].charAt(j)) != (c2 = words[i].charAt(j))) {
        			if (nexts[c1 - 'a'].contains(c2 - 'a')) break;
        			nexts[c1 - 'a'].add(c2 - 'a');
        			indeg[c2 - 'a']++;
        			break;
        		}
        	}
        }
        Queue<Integer> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) if (indeg[i] == 0) q.offer(i);
        while(!q.isEmpty()) {
        	int idx = q.poll();
        	sb.append((char)(idx + 'a'));
        	count--;
        	for (int i : nexts[idx]) {
        		indeg[i]--;
        		if (indeg[i] == 0) q.offer(i);
        	}
        }
        return count == 0 ? sb.toString() : "";
    }
	
	public static void main(String[] args) {
		Problem269 prob269 = new Problem269();
	    System.out.println(prob269.alienOrder(new String[]{"wrt",
	        "wrf",
	        "er",
	        "ett",
	        "rftt"}));
//	    System.out.println(prob269.alienOrder(new String[]{"z", "x"}));
//	    System.out.println(prob269.alienOrder(new String[]{"z", "x", "z"}));
//	    System.out.println(prob269.alienOrder(new String[]{"z", "z"}));
	    //System.out.println(prob269.alienOrder(new String[]{"zy", "zx"}));
	  }
}
