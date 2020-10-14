package comp.prep2019.less1000;
import java.util.*;
public class Prob728 {
	/**
	 * O(right - left)
	 * @param left
	 * @param right
	 * @return
	 */
	public List<Integer> selfDividingNumbers(int left, int right) {
	    List<Integer> result = new ArrayList<>();
	    for(int i = left; i <= right; i++){
	      if(isSelfDivisible(i)) result.add(i);
	    }
	    return result;
	  }

	  private boolean isSelfDivisible(int n){
	    int i = n;
	    int j = -1;
	    while(i > 0){
	      if((j = i % 10) == 0) return false;
	      if(n % j != 0) return false;
	      i = i / 10;
	    }
	    return true;
	  }
}
