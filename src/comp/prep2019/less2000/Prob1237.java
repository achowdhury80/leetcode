package comp.prep2019.less2000;
import java.util.*;

public class Prob1237 {
	/**
	 * O(x*Y)
	 * start with x = 1 and y = 1000
	 * if f value = z , then add x, y. x++ and y--
	 * if f > z then y--
	 * else x++
	 * @param customfunction
	 * @param z
	 * @return
	 */
	public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        int x = 1, y = 1000;
        int val = 0;
        List<List<Integer>> result = new ArrayList<>();
        while(x < 1001 && y > 0) {
        	val = customfunction.f(x,  y);
        	if (val == z) {
        		result.add(Arrays.asList(x, y));
        		x++;
        		y--;
        	} else if (val > z) {
        		y--;
        	} else x++;
        }
        return result;
    }
	
	class CustomFunction {
		 
		 public int f(int x, int y) {return 0;}
	}
}
