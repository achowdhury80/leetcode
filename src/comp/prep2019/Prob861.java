package comp.prep2019;

public class Prob861 {
	public int matrixScore(int[][] A) {
        int m = A.length, n = A[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            if (A[i][0] != 1) {
                for (int j = 0; j < n; j++) A[i][j] ^= 1;
            }
        }
        for (int i = 0; i < n; i++) {
        	int oneCount = 0;
        	for (int j = 0; j < m; j++) {
        		if (A[j][i] == 1) oneCount++;
        	}
        	oneCount = Math.max(oneCount, m - oneCount);
        	result += oneCount * (1 << (n - i - 1));
        }
        return result;
    }
}
