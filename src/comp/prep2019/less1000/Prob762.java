package comp.prep2019.less1000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Prob762 {
	public int countPrimeSetBits(int L, int R) {
	    Set<Integer> primeNumbers = new HashSet<>(Arrays.asList(new Integer[] {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31}));
	    int result = 0;
	    while(L <= R){
	      if(primeNumbers.contains(Integer.bitCount(L))) result++;
	      L++;
	    }
	    return result;
	}
}
