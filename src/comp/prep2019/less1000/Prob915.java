package comp.prep2019.less1000;

public class Prob915 {
	public int partitionDisjoint(int[] A) {
        int leftIdx = 0, leftMax = A[0], curMax = A[0];
        for (int i = 1; i < A.length - 1; i++) {
        	curMax = Math.max(curMax, A[i]);
        	if (A[i] < leftMax) {
        		leftIdx = i;
        		leftMax = curMax;
        	}
        }
        return leftIdx + 1;
    }
}
