package comp.prep2019;

public class Prob172 {
	public int trailingZeroes(int n) {
		if (n < 5) return 0;
        int result = (n = n / 5);
		return result + trailingZeroes(n);
    }
}
