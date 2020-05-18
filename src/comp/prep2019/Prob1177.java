package comp.prep2019;
import java.util.*;
public class Prob1177 {
	public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
		List<Boolean> result = new ArrayList<>();
		int[] arr = new int[s.length()];
		arr[0] ^= (1 << (s.charAt(0) - 'a'));
		for (int i = 1; i < s.length(); i++) {
			int idx = s.charAt(i) - 'a';
			arr[i] = arr[i - 1] ^ (1 << idx) ;
		}
		for (int[] q : queries) {
			if (q[2] >= 13) {
				result.add(true);
				continue;
			}
			int diff = Integer.bitCount(arr[q[1]] ^ (q[0] > 0 ? arr[q[0] - 1] : 0));
        	diff /= 2;
        	if (diff <= q[2]) result.add(true);
        	else result.add(false);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1177 prob = new Prob1177();
		System.out.println(prob.canMakePaliQueries("abcda", new int[][] {{3,3,0},{1,2,0},{0,3,1},{0,3,2},{0,4,1}}));
	}
}
