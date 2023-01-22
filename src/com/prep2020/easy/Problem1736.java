package com.prep2020.easy;

public class Problem1736 {
	public String maximumTime(String time) {
        if (time.charAt(4) == '?') time = time.substring(0, 4) + 9;
        if (time.charAt(3) == '?') time = time.substring(0, 3) + 5 + time.charAt(4);
        if ("??".equals(time.substring(0, 2))) time = "23" + time.substring(2);
        else if (time.charAt(1) == '?') {
        	if (time.charAt(0) == '2') time = "23" + time.substring(2);
        	else time = "" + time.charAt(0) + "9" + time.substring(2);
        }
        else if (time.charAt(0) == '?') {
        	if (time.charAt(1) < '4') time = "2" + time.substring(1);
        	else time = "1" + time.substring(1);
        }
        return time;
    }
}
