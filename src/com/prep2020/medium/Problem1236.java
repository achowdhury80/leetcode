package com.prep2020.medium;
import java.util.*;
public class Problem1236 {
	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostPartWithHttp = "http://" + findHost(startUrl);
        List<String> result = new ArrayList<>();
        result.add(startUrl);
        Set<String> visited = new HashSet<>();
        visited.add(startUrl);
        Queue<String> q = new LinkedList<>();
        q.offer(startUrl);
        while(!q.isEmpty()) {
        	String cur = q.poll();
        	List<String> urls = htmlParser.getUrls(cur);
        	if (urls != null) {
        		for (String url : urls) {
        			if (visited.contains(url) || !url.startsWith(hostPartWithHttp)) continue;
        			visited.add(url);
        			result.add(url);
        			q.offer(url);
        		}
        	}
        }
        return result;
    }
	
	private String findHost(String url) {
		String temp = url.substring("http://".length());
		int idx = temp.indexOf("/");
		return temp.substring(0, idx < 0 ? temp.length() : idx);
	}
	
	interface HtmlParser {
		      public List<String> getUrls(String url);
		 }
}
