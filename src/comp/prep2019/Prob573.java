package comp.prep2019;

public class Prob573 {
	public int minDistance(int height, int width, int[] tree, int[] squirrel, int[][] nuts) {
        int maxSqDistSaveStat = Integer.MIN_VALUE;
        int result = 0;
        for (int i = 0; i < nuts.length; i++) {
        	int distT = Math.abs(tree[0] - nuts[i][0]) + Math.abs(tree[1] - nuts[i][1]);
        	result += 2 * distT;
        	int distSaved = distT - Math.abs(squirrel[0] - nuts[i][0]) - Math.abs(squirrel[1] - nuts[i][1]);
        	if (distSaved > maxSqDistSaveStat) {
        		maxSqDistSaveStat = distSaved;
        	}
        }
        result -= maxSqDistSaveStat;
        return result;
    }
}
