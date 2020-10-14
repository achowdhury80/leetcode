package comp.prep2019.less1000;

public class Prob866 {
	public int primePalindrome(int N) {
        int place = 1;
        while (place * 10 < N) place *= 10;
        int[] result = new int[] {-1};
        while(true) {
        	findPalindromeNPrime(place, 1, 0, N, result);
        	if (result[0] > 0) return result[0];
        	place *= 10;
        }
    }
	
	private void findPalindromeNPrime(int left, int right, int number, int n, int[] result) {
		int[] pool;
		if (left >= right && result[0] < 1) {
			if (left == 1 && right == 1) {
				pool = new int[] {2, 3, 5, 7};
			} else if (right == 1) {
				pool = new int[] {1, 3, 7, 9};
			} else {
				pool = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
			}
			for (int a : pool) {
				int newNumber = number;
				newNumber += left * a + (left == right ? 0 : right * a);
				findPalindromeNPrime(left / 10, right * 10, newNumber, n, result);
			}
		}
		else if (result[0] < 1) {
			if (number >= n && isPrime(number)) {
				result[0] = number;
			}
		}
		
	}
	
	private boolean isPrime(int n) {
		int i = (int) Math.sqrt(n);
		int num = 3;
		while(num <= i) {
			if (n % num == 0) return false;
			num += 2;
		}
		return true;
	}
}
