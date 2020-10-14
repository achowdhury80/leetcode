package comp.prep2019.less2000;
import java.util.*;


public class Prob1152 {
	public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Pair>> map = new HashMap<>();
        for (int i = 0; i < username.length; i++) {
        	List<Pair> pairs = map.getOrDefault(username[i], new ArrayList<>());
        	pairs.add(new Pair(website[i], timestamp[i]));
        	map.put(username[i], pairs);
        }
        Map<String, Integer> seqCountMap = new HashMap<>();
        String result = "";
        for (String user : map.keySet()) {
        	List<Pair> list = map.get(user);
        	Collections.sort(list, (a, b) -> a.timestamp - b.timestamp);
        	Set<String> added = new HashSet<>();
        	for (int i = 0; i < list.size() - 2; i++) {
        		for (int j = i + 1; j < list.size() - 1; j++) {
        			for (int k = j + 1; k < list.size(); k++) {
        				String seq = list.get(i).web + " " + list.get(j).web + " " + list.get(k).web;
        				if (added.add(seq)) {
        					seqCountMap.put(seq, seqCountMap.getOrDefault(seq, 0) + 1);
        					if (result.equals("") || seqCountMap.get(result) < seqCountMap.get(seq) 
        							|| (seqCountMap.get(result) == seqCountMap.get(seq) && seq.compareTo(result) < 0)) {
        						result = seq;
        					}
        				}
        			}
        		}
        	}
        }
        String[] arr = result.split(" ");
        List<String> list = new ArrayList<>();
        for (String s : arr) list.add(s);
        return list;
    }
	
	class Pair {
		String web;
		int timestamp;
		Pair(String web, int timestamp) {
			this.web = web;
			this.timestamp = timestamp;
		}
	}
}
