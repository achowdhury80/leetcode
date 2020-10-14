package comp.prep2019;

public class Prob1374 {
	/**
	 * o(N) time
	 * @param n
	 * @return
	 */
	public String generateTheString(int n) {
		StringBuilder sb = new StringBuilder("a");
		boolean isOdd = n % 2 == 1;
        for (int i = 1; i < n; i++) sb.append(isOdd ? "a" : "b");
        return sb.toString();
    }
}
