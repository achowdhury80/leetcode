package com.leet.algo;

import java.util.Arrays;
import java.util.Comparator;

public class Prob937 {
	public String[] reorderLogFiles(String[] logs) {
		int end = logs.length - 1;
		for (int i = logs.length - 1; i > -1; i--) {
			String[] arr = logs[i].split(" ");
        	if (!Character.isLetter(arr[1].charAt(0))) {
        		swap(logs, i, end);
        		end--;
        	}
		}
		end++;
        Arrays.sort(logs, 0, end, new Comparator<String>() {
        	@Override
			public int compare(String s1, String s2) {
				return (s1.substring(s1.indexOf(" ") + 1) + s1.substring(0, s1.indexOf(" ")))
						.compareTo(s2.substring(s2.indexOf(" ") + 1) + s2.substring(0, s2.indexOf(" ")));
			}
        });
        return logs;
    }
	
	public void swap(String[] logs, int i, int j) {
		String temp = logs[i];
		logs[i] = logs[j];
		logs[j] = temp;
	}
}
