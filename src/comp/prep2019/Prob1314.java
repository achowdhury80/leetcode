package comp.prep2019;

public class Prob1314 {
	/**
	 * o(M *N) time and o(M *N) space
	 * find cumulative sum of mat[i][j]
	 * adjust height & width 
	 * @param mat
	 * @param K
	 * @return
	 */
	public int[][] matrixBlockSum(int[][] mat, int K) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		mat[i][j] += (j > 0 ? mat[i][j - 1] : 0) 
        				+ (i > 0 ? mat[i - 1][j] : 0) 
        				-((i > 0 && j > 0) ? mat[i - 1][j - 1] : 0);
        	}
        }
        for (int i = 0; i < m; i++) {
        	for (int j = 0; j < n; j++) {
        		result[i][j] = findBlockSum(mat, i + K >= m ? m - 1 : i + K, 
        				j + K >= n ? n - 1 : j + K, (i - K < 0 ? i : K) + 1 
        						+ (i + K < m ? K : m - i - 1), (j  - K < 0 ? j : K) + 1 
        						+ (j + K < n ? K : n - j - 1));
        	}
        }
        return result;
    }
	
	private int findBlockSum(int[][] mat, int i, int j, int height, int width) {
		int result = mat[i][j];
		if (i - height >= 0 && j - width >= 0) result += mat[i - height][j - width];
		if (i - height >= 0) result -= mat[i - height][j];
		if (j - width >= 0) result -= mat[i][j - width];
		return result;
	}
	
	public static void main(String[] args) {
		Prob1314 prob = new Prob1314();
		System.out.println(prob.matrixBlockSum(new int[][] {{1,2,3},{4,5,6},{7,8,9}},
				1));
	}
}
