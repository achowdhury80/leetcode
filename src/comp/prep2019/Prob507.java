package comp.prep2019;

public class Prob507 {
	/**
	 * O(sqrt(N)) time
	 * @param num
	 * @return
	 */
	public boolean checkPerfectNumber(int num) {
		if(num < 2) return false;
		int sum = 1;
        for (int i = 2; i <= Math.sqrt(num); i++) {
        	if (i * i == num) sum += i;
        	else if (num % i == 0) sum += i + num / i;
        }
        return sum == num;
    }
}
