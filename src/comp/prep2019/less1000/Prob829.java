package comp.prep2019.less1000;

public class Prob829 {
	public int consecutiveNumbersSum(int N) {
		int result = 0;
        for (int i = 1; i <= N; i++) {
        	if ((2 * N) % i != 0) continue;
        	int val = 2 * N / i + 1 - i;
        	if (val < 1) break;
        	if (val > 0 && val % 2 == 0) result++;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob829 prob = new Prob829();
		System.out.println(prob.consecutiveNumbersSum(15));
	}
}
