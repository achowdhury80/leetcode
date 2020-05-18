package comp.prep2019;

public class Prob1134 {
	/**
	 * O(length(N)) time
	 * find number of digits and compute powered sum of each digit
	 * @param N
	 * @return
	 */
	public boolean isArmstrong(int N) {
		int digits = N == 1 ? 1 : (int)Math.ceil(Math.log10(N));
		int sum = 0;
		int n = N;
		while(n > 0) {
			sum += Math.pow(n % 10, digits);
			n /= 10;
		}
		return sum == N;
    }
	
	public static void main(String[] args) {
		Prob1134 prob = new Prob1134();
		System.out.println(prob.isArmstrong(153));
	}
}
