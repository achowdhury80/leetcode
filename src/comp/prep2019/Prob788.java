package comp.prep2019;

public class Prob788 {
	/**
	 * O(n)
	 * 
	 * @param N
	 * @return
	 */
	public int rotatedDigits(int N) {
		int count = 0;
	    for (int i = 1; i <= N; i++) if (isValid(i)) count++;
	    return count;
    }
	
	private boolean isValid(int n) {
		boolean validFound = false;
		while(n > 0) {
			int d = n % 10;
			if (d == 2) validFound = true;
		    if (d == 5) validFound = true;
		    if (d == 6) validFound = true;
		    if (d == 9) validFound = true;
		    if (d == 3) return false;
		    if (d == 4) return false;
		    if (d == 7) return false;
			n /= 10;
		}
		return validFound;
	}
}
