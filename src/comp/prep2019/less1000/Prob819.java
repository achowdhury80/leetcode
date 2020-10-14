package comp.prep2019.less1000;
import java.util.*;
public class Prob819 {
	public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> set = new HashSet<>();
        Map<String, Integer> map = new HashMap<>();
        for (String w : banned) set.add(w);
        int maxFreq = 0;
        String result = "";
        char[] arr = paragraph.toCharArray();
        StringBuilder w = new StringBuilder("");
        for (int i = 0; i < arr.length; i++) {
        	if ("!?',;. ".indexOf(arr[i]) < 0) w.append(arr[i]);
        	else {
        		String s = w.toString().toLowerCase();
        		if (!s.equals("")) {
        			if (!set.contains(s)) {
        				int freq;
        				map.put(s, (freq = (map.getOrDefault(s, 0) + 1)));
                		if (freq > maxFreq) {
                			maxFreq = freq;
                			result = s;
                		}
        			}
        		}
        		w = new StringBuilder("");
        	}
        }
        String s = w.toString().toLowerCase();
		if (!s.equals("")) {
			if (!set.contains(s)) {
				int freq;
				map.put(s, (freq = (map.getOrDefault(s, 0) + 1)));
        		if (freq > maxFreq) {
        			maxFreq = freq;
        			result = s;
        		}
			}
		}
        return result;
    }
	
	
	public static void main(String[] args) {
		Prob819 prob = new Prob819();
		System.out.println(prob.mostCommonWord("Bob hit a ball, the hit BALL flew "
				+ "far after it was hit.", new String[] {"hit"}));
	}
}
