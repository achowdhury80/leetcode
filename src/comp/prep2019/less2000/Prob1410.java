package comp.prep2019.less2000;
import java.util.*;
public class Prob1410 {
	public String entityParser(String text) {
        Map<String, String> map = new HashMap<>();
        map.put("&quot;", "\"");
        map.put("&apos;", "'");
        map.put("&amp;", "&");
        map.put("&gt;", ">");
        map.put("&lt;", "<");
        map.put("&frasl;", "/");
        StringBuilder result = new StringBuilder(), temp = new StringBuilder();
        boolean started = false;
        for (char c : text.toCharArray()) {
        	if (started) {
        		if (c == ';') {
        			temp.append(c);
        			started = false;
        			String s = temp.toString();
        			temp = new StringBuilder();
        			for (Map.Entry<String, String> entry : map.entrySet()) {
        				int idx = -1;
        				if ((idx = s.indexOf(entry.getKey())) > -1) {
        					result.append(s.substring(0, idx) + entry.getValue());
        					s = "";
        					break;
        				}
        			}
        			result.append(s);
        		} else temp.append(c);
        	} else {
        		if (c == '&') {
        			temp.append(c);
        			started = true;
        		} else result.append(c);
        	}
        }
        result.append(temp);
        return result.toString();
    }
}
