package comp.prep2019.less1000;

public class Prob372 {
	public int superPow(int a, int[] b) {
		int result = 1, mod = 1337;
        for (int i = b.length - 1; i > -1; i--) {
        	result = (int)((1l * result * powMod(a, b[i])) % mod);
        	a = powMod(a, 10);
        }
        return result;
    }
	
	private int powMod(int a, int b) {
		if (b == 0) return 1;
		int result = 1;
		for (int i = 0; i < b; i++) result = (int)((1l * result * a) % 1337);
		return result;
	}
}
