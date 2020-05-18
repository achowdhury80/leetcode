package comp.prep2019;
import java.util.*;
public class Prob954 {
	/*
	 * o(nlogn)
	 * first sort
	 * put the counts in map
	 * look for even zeros
	 * in the sorted array start from lowest and iterate
	 * if negative, look for half and for positive look for double and adjust count accordingly
	 */
	public boolean canReorderDoubled(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        int zeroCount = 0;
        for (int a : A) {
        	map.put(a, map.getOrDefault(a, 0) + 1);
        	if (a == 0)zeroCount++;
        }
        if (zeroCount % 2 != 0) return false;
        Arrays.sort(A);
        for (int i = 0; i < A.length; i++) {
        	if (!map.containsKey(A[i])) continue;
        	if (A[i] < 0) {
        		if (A[i] % 2 != 0) return false;
        		int half = A[i] / 2; 
        		int freq = map.remove(A[i]);
        		if (!map.containsKey(half)) return false;
        		int halfFreq = map.get(half);
        		if (halfFreq < freq) return false;
        		if (halfFreq == freq) map.remove(half);
        		else map.put(half, halfFreq - freq);
        	} else if (A[i] > 0){
        		int twice = A[i] * 2; 
        		int freq = map.remove(A[i]);
        		if (!map.containsKey(twice)) return false;
        		int twiceFreq = map.get(twice);
        		if (twiceFreq < freq) return false;
        		if (twiceFreq == freq) map.remove(twice);
        		else map.put(twice, twiceFreq - freq);
        	}
        }
        return true;
    }
	
	public static void main(String[] args) {
		Prob954 prob = new Prob954();
		System.out.println(prob.canReorderDoubled(new int[] {4, -2, 2, -4}));
	}
}
