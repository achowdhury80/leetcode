package comp.prep2019;
import java.util.*;
public class Prob1004 {
	public int longestOnes(int[] A, int K) {
		int result = K;
		int start = 0;
		List<Integer> list = new ArrayList<>();
		int i = 0;
		for( i = 0; i < A.length; i++) {
			if (A[i] == 0) {
				if (list.size() < K) {
					list.add(i);
				} else {
					result = Math.max(result, i - start);
					if (K > 0) {
						start = list.remove(0) + 1;
						list.add(i);
					} else start = i + 1;
				}
			}
		}
		result = Math.max(result, i - start);
		return result;
    }
	
	public static void main(String[] args) {
		Prob1004 prob = new Prob1004();
		System.out.println(prob.longestOnes(new int[] {1,1,1,0,0,0,1,1,1,1,0},
				2));
	}
}
