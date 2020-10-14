package comp.prep2019.less1000;
import java.util.*;
public class Prob497 {
	private int total;
	private List<Integer> preSum;
	private int[][] rects;
	private Random random;
	public Prob497(int[][] rects) {
		this.rects = rects;
		this.preSum = new ArrayList<>();
		for (int[] x : rects) {
			total += (x[2] - x[0] + 1) * (x[3] - x[1] + 1);
			preSum.add(total);
		}
		random = new Random();
    }
    
    public int[] pick() {
        int target = random.nextInt(total);
        int low = 0, hi = rects.length - 1;
        while(low != hi) {
        	int mid = low + (hi - low) / 2;
        	if (preSum.get(mid) <= target) low = mid + 1;
        	else hi = mid;
        }
        int[] x = rects[low];
        int width = x[2] - x[0] + 1, height = x[3] - x[1] + 1;
        int base = preSum.get(low) - width * height;
        return new int[] {x[0] + (target - base) % width, 
        		x[1] + (target - base) / width};
    }
}
