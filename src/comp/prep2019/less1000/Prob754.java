package comp.prep2019.less1000;

public class Prob754 {
	public int reachNumber(int target) {
        target = Math.abs(target);
        int sum = 0;
        int result = 0, n = 1;
        while(sum < target || (sum - target) % 2 != 0) {
        	sum += n;
        	n++;
        	result++;
        }
        return result;
    }
}
