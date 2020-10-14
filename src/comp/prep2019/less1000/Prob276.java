package comp.prep2019.less1000;

public class Prob276 {
	public int numWays(int n, int k) {
		if (n < 1) return 0;
        int sameColor = 0, diffColor = k;
        for (int i = 1; i < n; i++) {
        	int temp = diffColor;
        	diffColor = (sameColor + diffColor) * (k - 1);
        	sameColor = temp;
        }
        return sameColor + diffColor;
    }
}
