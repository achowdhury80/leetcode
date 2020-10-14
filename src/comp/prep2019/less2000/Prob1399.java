package comp.prep2019.less2000;
import java.util.*;
public class Prob1399 {
	public int countLargestGroup(int n) {
		int last = 0;
		Map<Integer, Integer> map = new HashMap<>();
		int largestGroupCount = 0;
		int temp;
        for (int i = 1; i <= n; i++) {
        	last++;
        	map.put(last, (temp = map.getOrDefault(last, 0) + 1));
        	largestGroupCount = Math.max(largestGroupCount, temp);
        	if (i % 10 == 9) {
        		last = findSum(i + 1);
        		last--;
        	}
        }
        int result = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
        	if (entry.getValue() == largestGroupCount) result++;
        }
        return result;
    }
	
	private int findSum(int num) {
		int sum = 0;
		while(num > 0) {
			sum += (num % 10);
			num /= 10;
		}
		return sum;
	}
}
