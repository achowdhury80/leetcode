package com.prep2020.hard;
import java.util.*;
public class Problem2254 {
	private Map<Integer, int[]> map;
	private Map<Integer, String> content;
	private int id = 0;
	private Queue<Integer> pq;
	public Problem2254() {
        map = new HashMap<>();
        content = new HashMap<>();
        pq = new PriorityQueue<>();
        pq.offer(id);
    }
    
    public int upload(String video) {
        int id = pq.poll();
        if (pq.isEmpty()) pq.offer(id + 1);
        map.put(id, new int[3]);
        content.put(id, video);
        return id;
    }
    
    public void remove(int videoId) {
        if (!map.containsKey(videoId)) return;
        map.remove(videoId);
        content.remove(videoId);
        pq.offer(videoId);
    }
    
    public String watch(int videoId, int startMinute, int endMinute) {
        if (!map.containsKey(videoId)) return "-1";
        map.get(videoId)[2]++;
        return content.get(videoId).substring(startMinute, Math.min(endMinute + 1, content.get(videoId).length()));
    }
    
    public void like(int videoId) {
    	if (map.containsKey(videoId)) map.get(videoId)[0]++;
    }
    
    public void dislike(int videoId) {
    	if (map.containsKey(videoId)) map.get(videoId)[1]++;
    }
    
    public int[] getLikesAndDislikes(int videoId) {
    	 if (!map.containsKey(videoId)) return new int[] {-1};
    	 return new int[] {map.get(videoId)[0], map.get(videoId)[1]};
    }
    
    public int getViews(int videoId) {
        if (!map.containsKey(videoId)) return -1;
        return map.get(videoId)[2];
    }
}
