package comp.prep2019;
import java.util.*;
public class Prob1236 {
	public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        Set<String> result = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(startUrl);
        String[] ss = startUrl.split("/");
        String hostName = ss[2];
        result.add(startUrl);
        while(!q.isEmpty()) {
        	String url = q.poll();
        	List<String> nexts = htmlParser.getUrls(url);
        	if (nexts != null) {
        		for (String next : nexts) {
        			if (next.contains(hostName) && !result.contains(next)) {
        				q.offer(next);
        				result.add(next);
        			}
        		}
        	}
        }
        return new ArrayList<>(result);
    }
	
	interface HtmlParser {
		     public List<String> getUrls(String url);
	}
}
