package com.prep2020.medium;
import java.util.*;
public class Problem1348 {
	private Map<String, List<Integer>> map;
	public Problem1348() {
        this.map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        List<Integer> list = map.getOrDefault(tweetName, 
        		new ArrayList<>());
        int idx = Collections.binarySearch(list, time);
        if (idx < 0) idx = -(idx + 1);
        list.add(idx, time);
        map.put(tweetName, list);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, 
    		String tweetName, int startTime, int endTime) {
    	List<Integer> result = new ArrayList<>();
    	if (!map.containsKey(tweetName)) return result;
    	List<Integer> list = map.get(tweetName);
    	int idx = Collections.binarySearch(list, startTime);
    	if (idx < 0) idx = -(idx + 1);
    	int period = 60;
    	if ("hour".equals(freq)) period = 3600;
    	else if ("day".equals(freq)) period = 86400;
    	int last = startTime - 1;
    	int end = last + period;
    	int count = 0;
    	while(end < endTime) {
    		count = 0;
    		while(idx < list.size() && list.get(idx) <= end) {
    			count++;
    			last = list.get(idx);
    			idx++;
    		}
    		result.add(count);
    		last = end;
    		end = last + period;
    	}
    	count = 0;
    	while(idx < list.size() && list.get(idx) <= endTime) {
			count++;
			last = list.get(idx);
			idx++;
		}
    	result.add(count);
    	return result;
    }
}
