package com.leet.algo;

public class Prob878 {
	/**
	 * find lcm
	 * range is 2 and Min(A, B)* N
	 * do binary search
	 * find number of divisible(c) withing mid
	 * if c == N
	 * find the nearest divisible less than mid
	 * if c > N then r = mid
	 * else l = mid + 1
	 * @param N
	 * @param A
	 * @param B
	 * @return
	 */
	public int nthMagicalNumber(int N, int A, int B) {
        int lcm = findLcm(A, B);
        long r = (A + 0l) * N;
        if (B < A) r =  (B + 0l) * N;
        long l = 2;
        while(l < r) {
        	long mid = l + (r - l) / 2;
        	long c = count(mid, N, A, B, lcm);
        	if (c == N) {
        		l = mid;
        		break;
        	} else if (c > N) r = mid;
        	else l = mid + 1;
        }
        l =  l - ((l % A) > (l % B) ? (l % B) : (l % A));
        return (int)(l % (1e9 + 7));
    }
	
	private int findLcm(int x, int y) {
		return (x * y) / findGcd(x, y);
	}
	
	private int findGcd(int x, int y) {
		if (x < y) return findGcd(y, x);
		if (y == 0) return x;
		return findGcd(y, x % y);
	}
	
	private long count(long num, int n, int a, int b, int lcm) {
		return (num / a + num / b - num / lcm);
	}
	
	public static void main(String[] args) {
		Prob878 prob = new Prob878();
		System.out.println(prob.nthMagicalNumber(3, 8, 3));
	}
}
