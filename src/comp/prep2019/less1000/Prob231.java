package comp.prep2019.less1000;

public class Prob231 {
	public boolean isPowerOfTwo(int n) {
        if (n < 1) return false;
        return (n & (n - 1)) == 0;
    }
}
