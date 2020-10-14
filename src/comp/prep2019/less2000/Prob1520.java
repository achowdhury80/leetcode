package comp.prep2019.less2000;
import java.util.*;
public class Prob1520 {
	public List<String> maxNumOfSubstrings(String s) {
        int[][] intervals = new int[26][];
        for (int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	int idx = c - 'a';
        	if (intervals[idx] == null) {
        		intervals[idx] = new int[2];
        		intervals[idx][0] = i;
        	}
        	intervals[idx][1] = i;
        }
        Queue<int[]> q = new PriorityQueue<>((x, y) -> (x[1] - x[0] - y[1] + y[0]));
        for (int i = 0; i < 26; i++) {
        	int[] cur = intervals[i];
        	if (cur == null) continue;
        	char c = s.charAt(cur[0]);
        	boolean valid = true;
        	for (int j = cur[0] + 1; j <= cur[1]; j++) {
        		char newChar = s.charAt(j);
        		if (c != newChar) {
        			int[] otherInterval = intervals[newChar - 'a'];
        			if (otherInterval[0] < cur[0] || otherInterval[1] > cur[1]) {
        				valid = false;
        				break;
        			}
        		}
        	}
        	if (valid) q.offer(cur);
        }
        List<String> result = new ArrayList<>();
        TreeMap<Integer, Integer> usedIntervals = new TreeMap<>();
        while(!q.isEmpty()) {
        	int[] interval = q.poll();
        	if (isNotBlocked(interval, usedIntervals)) {
        		result.add(s.substring(interval[0], interval[1] + 1));
        	}
        }
        if (result.isEmpty()) result.add(s);
        return result;
    }

	private boolean isNotBlocked(int[] interval, 
			TreeMap<Integer, Integer> usedIntervals) {
		Map.Entry<Integer, Integer> lower = usedIntervals.lowerEntry(interval[0]);
		Map.Entry<Integer, Integer> upper = usedIntervals.higherEntry(interval[0]);
		if (lower != null && lower.getValue() >= interval[0]) return false;
		if (upper != null && upper.getKey() <= interval[1]) return false;
		usedIntervals.put(interval[0], interval[1]);
		return true;
	}
	
	public static void main(String[] args) {
		Prob1520 prob = new Prob1520();
		System.out.println(prob.maxNumOfSubstrings("adefaddaccc"));
	}
}
