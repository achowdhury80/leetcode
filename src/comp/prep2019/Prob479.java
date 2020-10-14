package comp.prep2019;

public class Prob479 {
	/**
	 * O((10^n) time 
	 * @param n
	 * @return
	 */
	public int largestPalindrome(int n) {
        if (n == 1) return 9;
        int max = (int) (Math.pow(10, n) - 1);
        for (int v = max; v > max / 10; v--) {
        	long pal = Long.parseLong(v + new StringBuilder("" + v).reverse().toString());
        	for (long x = max; x * x >= pal; x--) {
        		if (pal % x == 0) return (int)(pal % 1337);
        	}
        }
        return -1;
    }
	
	public static void main(String[] args) {
		Prob479 prob = new Prob479();
		System.out.println(prob.largestPalindrome(2));
	}
}
