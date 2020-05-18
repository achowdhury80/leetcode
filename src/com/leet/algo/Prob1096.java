package com.leet.algo;
import java.util.*;
public class Prob1096 {
	public List<String> braceExpansionII(String expression) {
        char[] arr = expression.toCharArray();
        List<String> result = new ArrayList<>();
        Deque<List<String>> q = new ArrayDeque<>();
        for (int i = 0; i < arr.length; i++) {
        	if (arr[i] == '{') {
        		int j = i;
        		int count = 1;
        		while(count > 0) {
        			j++;
        			if (arr[j] == '{') {
        				count++;
        			} else if (arr[j] == '}') count--;
        		}
        		
        		List<String> s = braceExpansionII(expression.substring(i + 1, j));
        		q.offerLast(s);
        		i = j;
        	} else if (arr[i] == ',') {
        		List<String> s = new ArrayList<>();
        		s.add(",");
        		q.offerLast(s);
        	} else {
        		List<String> s = new ArrayList<>();
        		s.add("" + arr[i]);
        		q.offerLast(s);
        	}
        }
        List<String> first = q.pollFirst();
        while(!q.isEmpty()) {
        	List<String> s = q.pollFirst();
        	if (s.size() == 1 && s.iterator().next() == ",") {
        		s = q.pollFirst();
        		List<String> temp = new ArrayList<>();
        		temp.addAll(first);
        		for (String a : s) {
        			if(!first.contains(a)) temp.add(a);
        		}
        		first = temp;
        	} else {
        		List<String> temp = new ArrayList<>();
        		for (String a : first) {
        			for (String b : s) {
        				temp.add(a + b);
        			}
        		}
        		first = temp;
        	}
        }
        Collections.sort((result = new ArrayList<>(first)));
        return result;
    }
	
	public static void main(String[] args) {
		Prob1096 prob = new Prob1096();
		System.out.println(prob.braceExpansionII("{{a,z},a{b,c},{ab,z}}"));
	}
}
