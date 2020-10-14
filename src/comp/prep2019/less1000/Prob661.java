package comp.prep2019.less1000;

public class Prob661 {
	public int[][] imageSmoother(int[][] M) {
		int lowerByteMask = (1 << 8) - 1;
        for (int i = 0; i < M.length; i++) {
        	for (int j = 0; j < M[0].length; j++) {
        		int sum = 0, count = 0;
        		for (int x = i - 1; x < i + 2; x++) {
        			for (int y = j - 1; y < j + 2; y++) {
        				if (x > -1 && x < M.length && y > -1 && y < M[0].length) {
        					sum += M[x][y] & lowerByteMask;
        					count++;
        				}
        			}
        		}
        		M[i][j] |= (sum / count) << 8;
        	}
        }
        for (int i = 0; i < M.length; i++) {
        	for (int j = 0; j < M[0].length; j++) {
        		M[i][j] >>= 8;
        	}
        }
        return M;
    }
}
