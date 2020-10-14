package comp.prep2019.less2000;
import java.util.*;
public class Prob1405 {
	public String longestDiverseString(int a, int b, int c) {
        String result = "";
        Queue<int[]> q = new PriorityQueue<>((x, y) -> y[1] - x[1]);
        if (a > 0) q.offer(new int[] {0, a});
        if (b > 0) q.offer(new int[] {1, b});
        if (c > 0) q.offer(new int[] {2, c});
        int[] blackListed = null;
        while(!q.isEmpty()) {
        	int[] cur = q.poll();
        	if (blackListed != null) q.offer(blackListed);
        	blackListed = null;
        	char ch = (char)(cur[0] + 'a');
        	result += ch;
        	cur[1]--;
        	if (cur[1] == 0) continue;
        	if (result.length() > 1 && result.charAt(result.length() - 2) == ch) blackListed = cur;
        	else q.offer(cur);
        }
        return result;
    }
}
