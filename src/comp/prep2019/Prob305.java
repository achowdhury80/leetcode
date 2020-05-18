package comp.prep2019;
import java.util.*;
public class Prob305 {
	public List<Integer> numIslands2(int m, int n, int[][] positions) {
        int[] parent = new int[m * n], size = new int[m * n];
        for (int i = 0; i < parent.length; i++) parent[i] = i;
        int[][] grid = new int[m][n];
        List<Integer> result = new ArrayList<>();
        int[][] dirs = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int land = 0;
        for (int[] pos : positions) {
        	if (grid[pos[0]][pos[1]] == 1) {
        		result.add(land);
        		continue;
        	}
        	grid[pos[0]][pos[1]] = 1;
        	int posIdx = pos[0] * n + pos[1];
        	size[posIdx] = 1;
        	Set<Integer> connectedSet = new HashSet<>();
        	connectedSet.add(posIdx);
        	for (int[] dir : dirs) {
        		int[] next = new int[] {pos[0] + dir[0], pos[1] + dir[1]};
        		if (next[0] < 0 || next[0] == m || next[1] < 0 || next[1] == n 
        				|| grid[next[0]][next[1]] == 0) continue;
        		connectedSet.add(findParent(parent, next[0] * n + next[1]));
        	}
        	List<Integer> list = new ArrayList<>(connectedSet);
        	Collections.sort(list, (x, y) -> size[x] == size[y] ? x - y 
        			: size[y] - size[x]);
        	
        	land += 2 - list.size();
        	int curParent = list.get(0);
        	for (int i = 1; i < list.size(); i++) {
        		parent[list.get(i)] = curParent;
        		size[curParent] += size[list.get(i)];
        	}
        	result.add(land);
        }
        return result;
    }
	
	private int findParent(int[] parent, int cur) {
		while(parent[cur] != cur) cur = parent[cur];
		return cur;
	}
}
