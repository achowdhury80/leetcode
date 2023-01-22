package com.prep2020.medium;
import java.util.*;
public class Problem423 {
	public String originalDigits(String s) {
        int[] charMap = new int[26];
        for (char c : s.toCharArray()) charMap[c - 'a']++;
        List<char[]> list = new ArrayList<>();
        String[] arr = new String[] {"zero", "one", "two", "three", "four", 
        		"five", "six", "seven", "eight", "nine"};
        list.add(new char[] {'z', '0'});
        list.add(new char[] {'w', '2'});
        list.add(new char[] {'u', '4'});
        list.add(new char[] {'f', '5'});
        list.add(new char[] {'v', '7'});
        list.add(new char[] {'s', '6'});
        list.add(new char[] {'g', '8'});
        list.add(new char[] {'t', '3'});
        list.add(new char[] {'o', '1'});
        list.add(new char[] {'i', '9'});
        Map<Integer, String> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
        	String st = helper(list.get(i), charMap, arr);
        	map.put(list.get(i)[1] - '0', st);
        }
        String result = "";
        for (int i = 0; i < 10; i++) result += map.get(i);
        return result;
    }
	
	private String helper(char[] chrs, int[] charMap, String[] arr) {
		int idx = chrs[0] - 'a';
		int count = 0;
		if ((count = charMap[idx]) == 0) return "";
		String result = "";
		for (int i = 0; i < count; i++) result += chrs[1];
		String w = arr[chrs[1] - '0'];
		for (char c : w.toCharArray()) {
			charMap[c - 'a'] -= count;
		}
		return result;
	}
}
