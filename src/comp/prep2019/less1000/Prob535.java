package comp.prep2019.less1000;
import java.util.*;
public class Prob535 {
	private Map<String, List<String>> map = new HashMap<>();
	// Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hex = Integer.toHexString(longUrl.hashCode());
        if (!map.containsKey(hex)) {
        	map.put(hex, new ArrayList<>());
        } else {
        	for (int i = 0; i < map.get(hex).size(); i++) {
        		String url = map.get(hex).get(i);
        		if (url.equals(longUrl)) return "http://tinyurl.com/" + hex + "#" + Integer.toHexString(i);
        	}
        }
        map.get(hex).add(longUrl);
        return "http://tinyurl.com/" + hex + "#" + Integer.toHexString(map.get(hex).size() - 1);
        
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
    	String[] strings = shortUrl.substring(19).split("#");
        return map.get(strings[0]).get((int)Long.parseLong(strings[1], 16));
    }
}
