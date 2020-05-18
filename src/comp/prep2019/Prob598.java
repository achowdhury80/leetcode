package comp.prep2019;

public class Prob598 {
	public int maxCount(int m, int n, int[][] ops) {
        int[] max = new int[] {m, n};
        for (int[] op : ops) {
        	max[0] = Math.min(max[0], op[0]);
        	max[1] = Math.min(max[1], op[1]);
        }
        return max[0] * max[1];
    }
}
