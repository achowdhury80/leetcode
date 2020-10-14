package comp.prep2019.less2000;

import java.util.Arrays;

public class Prob1101 {
	public int earliestAcq(int[][] logs, int N) {
        int[] parents = new int[N];
        for (int i = 0; i < N; i++) parents[i] = i;
        int islands = N;
        Arrays.sort(logs, (x, y) -> x[0] - y[0]);
        for (int[] log : logs) {
        	int a = log[1];
        	int b = log[2];
        	int parentA = findParent(parents, a);
        	int parentB = findParent(parents, b);
        	if (parentA != parentB) {
        		islands--;
        		parents[Math.max(parentA, parentB)] = Math.min(parentA, parentB);
        	}
        	if (islands == 1) return log[0];
        }
        return -1;
    }
	
	private int findParent(int[] parents, int i) {
		int cur = i;
		while(parents[cur] != cur) cur = parents[cur];
		return cur;
	}
}
