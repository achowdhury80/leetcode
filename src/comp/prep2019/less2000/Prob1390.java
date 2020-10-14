package comp.prep2019.less2000;

public class Prob1390 {
	public int sumFourDivisors(int[] nums) {
		int result = 0;
		for (int i : nums) {
			int sqrt = (int)Math.sqrt(i);
            if(sqrt*sqrt == i) continue;
			int tempSum = 1 + i;
			int count = 1;
			for (int j = 2; j <= sqrt; j++) {
				if (i % j == 0) {
					count++;
					tempSum += j + i / j;
				}
				if (count > 1) break;
			}
			if (count == 1) result += tempSum;
		}
		return result;
    }
}
