package comp.prep2019.less1000;

public class Prob74 {
	public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if(m < 1) return false;
        int n = matrix[0].length;
        if (n < 1) return false;
        int[] cur = new int[] {0, n - 1};
        while(true) {
        	int elem = matrix[cur[0]][cur[1]];
        	if (elem == target) return true;
        	if (elem > target) {
        		if (cur[1] == 0) return false;
        		cur[1]--;
        	} else {
        		if (cur[0] == m - 1) return false;
        		cur[0]++;
        	}
        }
    }
}
