package comp.prep2019.less1000;
import java.util.*;
public class Prob935 {
	public int knightDialer(int N) {
		int mod = (int)(1e9 + 7);
        if (N < 2) return 10;
        int[] arr = new int[10];
        for (int i = 0; i < 10; i++) {
        	if(i != 5) arr[i] = 1;
        }
        N--;
        Map<Integer, List<Integer>> nextMap = new HashMap<>();
        nextMap.put(0, Arrays.asList(4, 6));
        nextMap.put(1, Arrays.asList(6, 8));
        nextMap.put(2, Arrays.asList(7, 9));
        nextMap.put(3, Arrays.asList(4, 8));
        nextMap.put(4, Arrays.asList(0, 3, 9));
        nextMap.put(6, Arrays.asList(0, 7, 1));
        nextMap.put(7, Arrays.asList(2, 6));
        nextMap.put(8, Arrays.asList(1, 3));
        nextMap.put(9, Arrays.asList(2, 4));
        while(N > 0) {
        	int[] temp = new int[10];
        	for (int i = 0; i < 10; i++) {
        		if (i == 5) continue;
        		for (int j : nextMap.get(i)) {
        			temp[j] = (temp[j] + arr[i]) % mod; 
        		}
        	}
        	arr = temp;
        	N--;
        }
        int result = arr[0];
        for (int i = 1; i < 10; i++) {
        	result = (result + arr[i]) % mod;
        }
        return result;
    }
}
