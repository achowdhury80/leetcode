package com.leet.algo;
import java.util.*;
public class Prob727 {
	public String minWindow(String S, String T) {
		if(T.length() < 2) {
			return S.indexOf(T) > -1 ? T : "";
		}
        List<int[]> intervals = new ArrayList<>();
        intervals.add(new int[] {-1, -1});
        for (char c : T.toCharArray()) {
        	List<int[]> newIntervals = new ArrayList<>();
        	int last = 0;
        	for (int i = intervals.get(0)[1] + 1; i < S.length(); i++) {
        		if (last < intervals.size() - 1 && intervals.get(last + 1)[1] < i) last++;
        		if(S.charAt(i) == c) {
        			int[] cur = intervals.get(last);
        			int[] curUpdated = new int[] {cur[0] == -1 ? cur[1] : cur[0],i};
        			newIntervals.add(curUpdated);
        		}
        	}
        	intervals = newIntervals;
        	if(intervals.isEmpty()) return "";
        }
        String result = "";
        for (int[] interval : intervals) {
        	if(result.equals("") || result.length() > interval[1] - interval[0] + 1) result = S.substring(interval[0], interval[1] + 1);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob727 prob = new Prob727();
		System.out.println(prob.minWindow("abcdebdde", "bde"));
	}
}
