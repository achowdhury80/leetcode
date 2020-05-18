package comp.prep2019;

public class Prob947 {
	public int removeStones(int[][] stones) {
        int[] parents = new int[stones.length];
        for (int i = 0; i < parents.length; i++) parents[i] = i;
        int[] islands = new int[] {stones.length};
        for (int i = 0; i < stones.length - 1; i++) {
        	for (int j = i + 1; j < stones.length; j++) {
        		if (stones[i][0] == stones[j][0] || stones[i][1] == stones[j][1]) {
        			union(i, j, parents, islands);
        		}
        	}
        }
        return stones.length - islands[0];
    }
	
	private void union(int i, int j, int[] parents, int[] islands) {
		int parentI = findParent(parents, i);
		int parentJ = findParent(parents, j);
		if (parentI != parentJ) {
			islands[0]--;
			parents[parentI] = parentJ;
		}
		
	}
	
	private int findParent(int[] parents, int i) {
		while (i != parents[i]) i = parents[i];
		return i;
	}
}
