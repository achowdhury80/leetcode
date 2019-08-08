package com.leet.algo;
import java.util.*;
public class Prob854 {
	public int kSimilarity(String A, String B) {
		if (A.equals(B)) return 0;
        Set<String> visited = new HashSet<>();
        int result = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(A);
        visited.add(A);
        while(!q.isEmpty()) {
        	int size = q.size();
        	result++;
        	for (int i = 0; i < size; i++) {
        		String s = q.poll();
        		int c = 0;
        		while(s.charAt(c) == B.charAt(c)) c++;
        		for (int j = c + 1; j < s.length(); j++) {
        			if(s.charAt(j) != B.charAt(c) || s.charAt(j) == B.charAt(j)) continue;
        			String newS = swap(s, c, j);
        			if(newS.equals(B)) return result;
        			if (!visited.contains(newS)) {
    					visited.add(newS);
    					q.offer(newS);
        			}
        		}
        	}
        }
        return -1;
    }
	
	private String swap(String s, int i, int j){
		char[] arr = s.toCharArray();
		char c = arr[i];
		arr[i] = arr[j];
		arr[j] = c;
		return new String(arr);
    }
}
