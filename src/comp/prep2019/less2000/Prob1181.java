package comp.prep2019.less2000;
import java.util.*;
public class Prob1181 {
	public List<String> beforeAndAfterPuzzles(String[] phrases) {
        Map<String, List<Integer>> startMap = new HashMap<>();
        Map<String, List<Integer>> endMap = new HashMap<>();
        for (int i = 0; i < phrases.length; i++) {
        	String[] arr = phrases[i].split(" ");
        	List<Integer> l1 = startMap.getOrDefault(arr[0], new ArrayList<>());
        	l1.add(i);
        	startMap.put(arr[0], l1);
        	List<Integer> l2 = endMap.getOrDefault(arr[arr.length - 1], new ArrayList<>());
        	l2.add(i);
        	endMap.put(arr[arr.length - 1], l2);
        }
        Set<String> set = new HashSet<>();
        for (Map.Entry<String, List<Integer>> entry : endMap.entrySet()) {
        	if (startMap.containsKey(entry.getKey())) {
        		List<Integer> l1 = entry.getValue();
        		List<Integer> l2 = startMap.get(entry.getKey());
        		for (int i : l1) {
        			String s1 = phrases[i];
        			for (int j : l2) {
        				if (j == i) continue;
        				String s2 = phrases[j];
        				if (s1.indexOf(" ") < 0) set.add(s2);
        				set.add(s1.substring(0, s1.lastIndexOf(" ") + 1) + s2);
        			}
        		}
        	}
        }
        List<String> result = new ArrayList<>(set);
        Collections.sort(result);
        return result;
    }
}
