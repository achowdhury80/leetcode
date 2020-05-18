package comp.prep2019;

public class Prob1010 {
	public int numPairsDivisibleBy60(int[] time) {
        int[] arr = new int[60];
        for (int t : time) arr[t % 60]++;
        int result = 0;
        for (int i = 0; i <= 30; i++) {
        	if (i == 0 || i == 30) {
        		result += (arr[i] * (arr[i] - 1)) / 2;
        	} else result += arr[i] * arr[60 - i];
        }
        return result;
    }
}
