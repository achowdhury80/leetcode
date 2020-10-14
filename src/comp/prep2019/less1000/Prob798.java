package comp.prep2019.less1000;
import java.util.*;
public class Prob798 {
	public int bestRotation(int[] A) {
		int n;
		if ((n = A.length) < 2) return 0;
        int[] arr = new int[n + 1];
        for (int i = 0; i < n; i++) {
        	List<int[]> moveIntervals = findMoveIntervals(A, i);
        	// manage a number line
        	// if interval is i to j then increment arr[i] and decrement arr[j + 1]
        	for (int[] interval : moveIntervals) {
        		arr[interval[0]]++;
        		arr[interval[1] + 1]--;
        	}
        }
        // we need to find the move number where it reaches max height
        int result = 0, move = 0, cur = 0;
        for (int i = 0; i < n; i++) {
        	cur += arr[i];
        	if (move < cur) {
        		move = cur;
        		result = i;
        	}
        }
        return result;
    }
	
	/**
	 * find for that elements possible move intervals
	 * [2, 3, 1, 4, 0]
	 * 0th -> 1 to 3
	 * 1st -> 2to 3
	 * 2nd -> 0 to 1 and 3 to 4
	 * 3rd -> 4 to 4
	 * 4th -> 0 to 4
	 * @param A
	 * @param i
	 * @return
	 */
	private List<int[]> findMoveIntervals(int[] A, int i) {
		List<int[]> result = new ArrayList<>();
		if (A[i] == A.length) return result;
		if (A[i] == i) {
			result.add(new int[2]);
			if (i < A.length - 1) {
				int[] interval = new int[2];
				interval[0] = i + 1;
				interval[1] = A.length - 1;
				result.add(interval);
			}
			
		} else if (A[i] > i) {
			int[] interval = new int[2];
			interval[0] = i + 1;
			interval[1] = i + 1 + A.length - 1 - A[i];
			result.add(interval);
		} else {
			if (i < A.length - 1) {
				int[] interval = new int[2];
				interval[0] = i + 1;
				interval[1] = A.length - 1;
				result.add(interval);
			}
			result.add(new int[] {0, i - A[i]});
		}
		return result;
	}
	
	public static void main(String[] args) {
		Prob798 prob = new Prob798();
		System.out.println(prob.bestRotation(new int[] {2, 3, 1, 4, 0}));
		System.out.println(prob.bestRotation(new int[] {2, 4, 1, 3, 0}));
	}
}
