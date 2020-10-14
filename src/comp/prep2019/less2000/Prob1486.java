package comp.prep2019.less2000;

public class Prob1486 {
	public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
        	result ^= (start + 2 * i);
        }
        return result;
    }
}
