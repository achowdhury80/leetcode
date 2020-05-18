package comp.prep2019;

public class Prob755 {
	public int[] pourWater(int[] heights, int V, int K) {
        for (int i = 0; i < V; i++) {
        	heights[K]++;
        	int k = K;
        	boolean used = false;
        	for (int j = K - 1; j > -1; j--) {
        		if (heights[j] >= heights[k]) break;
        		if (heights[j] < heights[k] - 1) {
        			heights[j]++;
        			heights[k]--;
        			used = true;
        			k = j;
        		}
        	}
        	if (used) continue;
        	for (int j = k + 1; j < heights.length; j++) {
        		if (heights[j] >= heights[k]) break;
        		if (heights[j] < heights[k] - 1) {
        			heights[j]++;
        			heights[k]--;
        			k = j;
        		}
        	}
        }
        return heights;
    }
}
