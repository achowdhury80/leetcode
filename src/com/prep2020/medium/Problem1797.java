package com.prep2020.medium;
import java.util.*;
public class Problem1797 {
	private int timeToLive;
	private Map<String, Integer> map;
	public Problem1797(int timeToLive) {
        this.timeToLive = timeToLive;
        map = new HashMap<>();
    }
    
    public void generate(String tokenId, int currentTime) {
    	map.put(tokenId, currentTime + timeToLive);
    }
    
    public void renew(String tokenId, int currentTime) {
        if (map.containsKey(tokenId) && map.get(tokenId) > currentTime)
        	generate(tokenId, currentTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
    	map.entrySet().removeIf(e-> e.getValue() <= currentTime);
        return map.size();
    }
}
