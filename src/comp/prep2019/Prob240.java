package comp.prep2019;

public class Prob240 {
	public boolean searchMatrix(int[][] matrix, int target) {
        int m, n;
        if((m = matrix.length) == 0 || (n = matrix[0].length) == 0) return false;
        int[] cur = new int[] {0, n - 1};
        while(cur[0] < m && cur[1] > -1) {
        	int val = matrix[cur[0]][cur[1]];
        	if (val == target) return true;
        	if (val > target) cur[1]--;
        	else cur[0]++;
        }
        return false;
    }
}
