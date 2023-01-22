package com.prep2020.medium;
import java.util.*;
public class Problem763 {
	/**
	 * O(NlogN)
	 * @param S
	 * @return
	 */
	public List<Integer> partitionLabels(String S) {
        int[][] charIndexRange = new int[26][2];
        for (int i = 0; i < 26; i++) charIndexRange[i] = new int[] {-1, -1};
        for (int i = 0; i < S.length(); i++) {
        	int charIdx = S.charAt(i) - 'a';
        	if (charIndexRange[charIdx][0] == -1) charIndexRange[charIdx][0] = i;
        	charIndexRange[charIdx][1] = i;
        }
        List<int[]> list = new ArrayList<>();
        for (int[] intv : charIndexRange) if(intv[0] != -1) list.add(intv);
        Collections.sort(list, (x, y) -> x[1] - y[1]);
        List<Integer> result = new ArrayList<>();
        for (int i = list.size() - 2; i > -1; i--) {
        	if (list.get(i)[1] > list.get(i + 1)[0]) {
        		list.get(i)[1] = list.get(i + 1)[1];
        		list.get(i)[0] = Math.min(list.get(i)[0], list.get(i + 1)[0]);
        		list.remove(i + 1);
        	}
        }

        for (int[] intv : list) result.add(intv[1] - intv[0] + 1);
        return result;
    }
	
	public static void main(String[] args) {
		Problem763 problem = new Problem763();
		System.out.println(problem.partitionLabels("ababcbacadefegdehijhklij"));
	}
}
