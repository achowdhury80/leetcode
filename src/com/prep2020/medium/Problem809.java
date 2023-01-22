package com.prep2020.medium;
import java.util.*;
public class Problem809 {
	public int expressiveWords(String s, String[] words) {
        List<int[]> sCount = findAdjCount(s);
        int result = 0;
        for (String w : words) {
        	List<int[]> wCount = findAdjCount(w);
        	if (sCount.size() != wCount.size()) continue;
        	boolean valid = true;
        	for (int i = 0; i < sCount.size(); i++) {
        		if (sCount.get(i)[0] != wCount.get(i)[0]) {
        			valid = false;
        			break;
        		}
        		if (sCount.get(i)[1] < wCount.get(i)[1] 
        				|| (sCount.get(i)[1] > wCount.get(i)[1]) 
        				&& sCount.get(i)[1] < 3) {
        			valid = false;
        			break;
        		};
        	}
        	if (valid) result++;
        }
        return result;
    }

	private List<int[]> findAdjCount(String s) {
		List<int[]> result = new ArrayList<>();
		for (char c : s.toCharArray()) {
			int idx = c - 'a';
			if (result.isEmpty() 
					|| result.get(result.size() - 1)[0] != idx) {
				result.add(new int[] {idx, 1});
			} else result.get(result.size() - 1)[1]++;
		}
		return result;
	}
}
