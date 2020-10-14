package comp.prep2019.less2000;

public class Prob1175 {
	/**
	 * O(N^2)
	 * @param n
	 * @return
	 */
	public int numPrimeArrangements(int n) {
        boolean[] notPrime = new boolean[n + 1];
        int count = 0;
        for (int i = 2; i <= n; i++) {
        	if (!notPrime[i]) {
        		count++;
        		int cur = 2;
        		while(i * cur <= n) {
        			notPrime[i * cur] = true;
        			cur++;
        		}
        	}
        }
        int mod = (int)(1e9 + 7);
        long prod = fact(count, mod) * fact(n - count, mod);
        return (int)(prod % mod);
    }
	
	private long fact(int n, int mod) {
		long count = 1;
		for (int i = n; i > 1; i--) count = (count * i) % mod;
		return count;
	}
	
	public static void main(String[] args) {
		Prob1175 prob = new Prob1175();
		System.out.println(prob.numPrimeArrangements(5));
		System.out.println(prob.numPrimeArrangements(100));
		System.out.println(prob.numPrimeArrangements(4));
	}
}
