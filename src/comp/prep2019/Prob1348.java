package comp.prep2019;
import java.util.*;
public class Prob1348 {
	private Map<String, TreeMap<Integer, Integer>> map;
	public Prob1348() {
        map = new HashMap<>();
    }
    
    public void recordTweet(String tweetName, int time) {
        TreeMap<Integer, Integer> treeMap = map.getOrDefault(tweetName, 
        		new TreeMap<>());
        map.put(tweetName, treeMap);
        treeMap.put(time, treeMap.getOrDefault(time, 0) + 1);
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, 
    		int startTime, int endTime) {
    	List<Integer> result = new ArrayList<>();
    	if (!map.containsKey(tweetName)) return result;
    	int interval = 60;
    	if ("hour".equals(freq)) interval = 3600;
    	else if ("day".equals(freq)) interval = 86400;
    	int size = ((endTime - startTime) / interval) + 1;
        
        int[] buckets = new int[size];
        
        TreeMap<Integer, Integer> tweetMap = map.get(tweetName);
        
        for (Map.Entry<Integer, Integer> entry : tweetMap.subMap(startTime, endTime + 1).entrySet()) {
            
            int index = (entry.getKey() - startTime) / interval;
            buckets[index] += entry.getValue();
        }
        
        for (int num : buckets) result.add(num);
    	return result;
    }
}
