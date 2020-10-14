package comp.prep2019.less1000;

public class Prob825 {
	public int numFriendRequests(int[] ages) {
        int[] ageSum = new int[121];
        for (int age : ages) ageSum[age]++;
        for (int i = 1; i < 121; i++) ageSum[i] += ageSum[i - 1];
        int result = 0;
        for (int i = 15; i < 121; i++) {
        	int n;
        	if ((n = ageSum[i] - ageSum[i - 1]) == 0) continue;
        	result += n * (n - 1);
        	int minAge =  (int)Math.floor(0.5 * i + 7);
        	int count = ageSum[i - 1] - ageSum[minAge];
        	result += n * count;
        }
        return result;
    }
}
