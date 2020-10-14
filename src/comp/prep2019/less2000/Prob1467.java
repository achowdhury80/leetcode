package comp.prep2019.less2000;

import java.util.Arrays;

public class Prob1467 {
	double[] dp = new double[100];
    public double getProbability(int[] balls) {
        dp[0] = 1;
        int sum = Arrays.stream(balls).sum();
        for (int i = 1; i < 100; i++) dp[i] = dp[i - 1] * i; //this is for calculate C(a, b) as explained in helper method
        double validNumber = dfs(0, 0, 0, 0, balls, 0);
        double totalNumber = combination(sum, sum / 2);   //how many different ways we can pick sum / 2 balls from sum
        return validNumber / totalNumber;
    }
    
    //count means the numebr of distinguish balls in one box, sum means total balls in one box
    private double dfs(int count1, int count2, int sum1, int sum2, int[] balls, int i) {
        if (i == balls.length) return (sum1 == sum2 && count1 == count2) ? 1 : 0;
        double res = dfs(count1 + 1, count2, sum1 + balls[i], sum2, balls, i + 1);
        res += dfs(count1, count2 + 1, sum1, sum2 + balls[i], balls, i + 1);
        for (int j = 1; j < balls[i]; j++)
            res += combination(balls[i], j) * dfs(count1 + 1, count2 + 1, sum1 + j, sum2 + balls[i] - j, balls, i + 1);
        return res;
    }
    
    //combination way to calculate pick b from a: C(a, b), eg C(4, 2) = dp[4] / dp[2] / dp[4 - 2] = 6
    private double combination(int a, int b) {
        return dp[a] / dp[b] / dp[a - b];
    }
	
	public static void main(String[] args) {
		Prob1467 prob = new Prob1467();
		System.out.println(prob.getProbability(new int[] {2, 1, 1}));
	}
}
