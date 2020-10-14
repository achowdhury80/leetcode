package comp.prep2019.less1000;

public class Prob132 {
	public int minCut(String s) {
		int n = s.length();
		boolean[][] isPal = new boolean[n][n];
        char[] arr = s.toCharArray();
        int[] cut = new int[n + 1];
        cut[0] = -1;
        for (int i = 1; i <= n; i++) {
        	cut[i] = i - 1;
        	for (int j = 0; j < i; j++) {
        		if (arr[j] == arr[i - 1] && (j + 2 >= i || isPal[j + 1][i - 2])) {
        			cut[i] = Math.min(cut[i], cut[j] + 1);
        			isPal[j][i - 1] = true;
        		}
        	}
        }
        return cut[n];
    }
}
