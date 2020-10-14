package comp.prep2019.less1000;
import java.util.*;
public class Prob864 {
	public int shortestPathAllKeys(String[] grid) {
        int m = grid.length, n = grid[0].length();
        boolean[] keys = new boolean[6];
        int[] start = null;
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		char c = grid[i].charAt(j);
        		if (c == '@') start = new int[] {i, j};
        		else if (c != '#' && c != '.' && c >= 'a') keys[c - 'a'] = true;
        	}
        }
        int count = 0;
        Map<Character, Integer> keyIndexMap = new HashMap<>();
        for (int i = 0; i < 6; i++) {
        	if (keys[i]) {
        		keyIndexMap.put((char)('a' + i), count++);
        	}
        }
        if (count == 0) return 0;
        boolean[][][] visited = new boolean[m][n][1 << count];
        Queue<int[]> q = new LinkedList<>();
        int result = 0;
        q.offer(new int[] {start[0], start[1], 0});
        visited[start[0]][start[1]][0] = true;
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		int[] cur = q.poll();
        		for (int[] dir : dirs) {
        			int[] next = new int[] {cur[0] + dir[0], cur[1] + dir[1], 
        					cur[2]};
        			char c;
        			if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n 
        					|| (c = grid[next[0]].charAt(next[1])) == '#') continue;
        			if (c >= 'A' && c <= 'F') {
        				int keyId = keyIndexMap.get(Character.toLowerCase(c));
        				if ((next[2] & (1 << keyId)) == 0) continue;
        			} else if (c >= 'a' && c <= 'f') {
        				int keyId = keyIndexMap.get(c);
        				next[2] |= (1 << keyId);
        			}
        			boolean[] arr = visited[next[0]][next[1]];
        			if (arr[next[2]]) continue;
        			boolean found = false;
        			for (int j = arr.length - 1; j > -1; j--) {
        				if (arr[j] && isBitWiseSubset(next[2], j)) {
        					found = true;
        					break;
        				}
        			}
        			if (found) continue;
        			if (next[2] == (1 << count) - 1) return result;
        			arr[next[2]] = true;
        			q.offer(next);
        		}
        	}
        }
        return -1;
    }
	
	private boolean isBitWiseSubset(int sub, int mask) {
		if (sub == 0) return true;
		return (sub & mask) == sub;
		
	}
}
