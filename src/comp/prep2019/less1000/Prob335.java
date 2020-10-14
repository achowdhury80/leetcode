package comp.prep2019.less1000;

public class Prob335 {
	/**
	 * https://www.youtube.com/watch?v=b8iINtg7zbs
	 * @param x
	 * @return
	 */
	public boolean isSelfCrossing(int[] x) {
        if (x.length < 4) return false;
        for (int i = 3; i < x.length; i++) {
        	if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3]) return true;
        	if(i >= 4 && x[i - 3] == x[i - 1] && x[i - 2] <= x[i] + x[i - 4])
        		return true;
        	if (i >= 5 && x[i - 2] <= x[i] + x[i - 4] 
        			&& x[i - 3] <= x[i - 1] + x[i - 5] && x[i - 2] > x[i -4] 
        					&& x[i - 3] > x[i - 1]) return true;
        }
        return false;
    }
}
