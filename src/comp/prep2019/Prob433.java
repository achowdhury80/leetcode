package comp.prep2019;
import java.util.*;
public class Prob433 {
	public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>();
        for (String s : bank) set.add(s);
        if (!set.contains(end)) return -1;
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        q.offer(start);
        visited.add(start);
        int dis = 0;
        char[] arr = new char[] {'A', 'C', 'G', 'T'};
        while(!q.isEmpty()) {
        	int size = q.size();
        	dis++;
        	for (int i = 0; i < size; i++) {
        		String cur = q.poll();
        		for (int j = 0; j < cur.length(); j++) {
        			for (char c : arr) {
        				if (cur.charAt(j) == c) continue;
        				String next = (j > 0 ? cur.substring(0, j) : "") 
        						+ c 
        						+ (j < cur.length() - 1 ? cur.substring(j + 1) : "");
        				if (end.equals(next)) return dis;
        				if (!set.contains(next) || visited.contains(next)) continue;
        				q.offer(next);
        				visited.add(next);
        			}
        		}
        	}
        }
        return -1;
    }
}
