package com.prep2020.easy;
import java.util.*;
public class Problem359 {
	private Map<String, Integer> map;
	public Problem359() {
        map = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!map.containsKey(message) || timestamp - map.get(message) >= 10) {
        	map.put(message, timestamp);
        	return true;
        }
        return false;
    }
}
