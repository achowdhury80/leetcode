package comp.prep2019.less2000;

public class Prob1318 {
	/**
	 * O(1)
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public int minFlips(int a, int b, int c) {
        int result = 0;
        for (int i = 0; i < 32 && (a > 0 || b > 0 || c > 0); i++) {
        	int m = (a & 1), n = (b & 1), p = (c & 1);
        	if (p == 0 && m == 1 && n == 1) result += 2;
        	else if (p == 0 && (m + n) == 1) result += 1;
        	else if (p == 1 && m == 0 && n == 0) result += 1;
            a >>= 1;
        	b >>= 1;
        	c >>= 1;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1318 prob = new Prob1318();
		System.out.println(prob.minFlips(8, 3, 5));
	}
}
