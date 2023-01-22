package com.prep2020.easy;

import java.util.Arrays;

public class Problem937 {
	public String[] reorderLogFiles(String[] logs) {
        int digitIndex = logs.length;
        for (int i = logs.length - 1; i > -1; i--) {
        	if (isDigitLog(logs[i])) {
        		String temp = logs[digitIndex - 1];
        		logs[digitIndex - 1] = logs[i];
        		logs[i] = temp;
        		digitIndex--;
        	}
        }
        if (digitIndex == 0) return logs;
        Arrays.sort(logs, 0, digitIndex, (x, y) -> {
        	int xSpaceIndex = x.indexOf(' '), ySpaceIndex = y.indexOf(' ');
        	if (x.substring(xSpaceIndex).compareTo(y.substring(ySpaceIndex)) == 0) 
        		return x.substring(0, xSpaceIndex).compareTo(y.substring(0, ySpaceIndex));
        	return x.substring(xSpaceIndex).compareTo(y.substring(ySpaceIndex));
        });
        return logs;
    }
	
	private boolean isDigitLog(String log) {
		String[] arr = log.split(" ");
		char c = arr[1].charAt(0);
		if (c >= '0' && c <= '9') return true;
		return false;
	}
}
