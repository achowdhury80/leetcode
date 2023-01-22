package com.prep2020.medium;
import java.util.*;
public class Problem1016 {
	/**
	 * O(N) time and space
	 * @param s
	 * @param n
	 * @return
	 */
	public boolean queryString(String s, int n) {
        if (s.indexOf('1') < 0) return false;
        if (n == 1) return true;
        if (s.indexOf('0') < 0) return false;
        List<String> list = new ArrayList<>();
        list.add("0");
        list.add("1");
        int count = 1;
        while(count < n) {
        	List<String> temp = new ArrayList<>();
        	for (String st : list) temp.add("0" + st);
        	for (String st : list) {
        		String newSt = "1" + st;
        		if (s.indexOf(newSt) < 0) return false;
        		count++;
        		temp.add(newSt);
        		if (count == n) break;
        	}
        	list = temp;
        }
        return true;
    }
	
	public static void main(String[] args) {
		Problem1016 problem = new Problem1016();
		System.out.println(problem.queryString("0110", 4));
	}
}
