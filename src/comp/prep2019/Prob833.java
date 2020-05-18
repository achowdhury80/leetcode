package comp.prep2019;
import java.util.*;
public class Prob833 {
	public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
		StringBuilder sb = new StringBuilder();
		Queue<int[]> q = new PriorityQueue<>((x, y) -> (x[1] - y[1]));
		for (int i = 0; i < indexes.length; i++) q.offer(new int[] {i, indexes[i]});
		if (q.isEmpty()) return S;
		int cur = q.poll()[0];
        for (int i = 0; i < S.length(); i++) {
        	if (i == indexes[cur]) {
        		if (matches(S, indexes[cur], sources[cur])) {
        			i += sources[cur].length() - 1;
        			sb.append(targets[cur]);
        		} else sb.append(S.charAt(i));
        		if (!q.isEmpty()) cur = q.poll()[0];
        	} else sb.append(S.charAt(i));
        }
        return sb.toString();
    }
	
	private boolean matches(String s, int startIdx, String source) {
		if (startIdx + source.length() > s.length()) return false;
		for(int i = 0; i < source.length(); i++) {
			if (s.charAt(startIdx + i) != source.charAt(i)) return false;
		}
		return true;
	}
}
