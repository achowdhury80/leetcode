package comp.prep2019.less1000;

public class Prob201 {
	/**
	 * check each bit starting from the leftmost for biggest and smallest number
	 * if they are same, the bit is part of result
	 * if not, return
	 * @param m
	 * @param n
	 * @return
	 */
	public int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        for (int i = 31; i > -1; i--) {
        	//check whether ith bit are equal
        	if(((m >> i) & 1) == ((n >> i) & 1)) {
        		// set the ith bit of result equal to ith bit of m or n
        		result ^= (m & (1 << i));
        	}
        	else return result;
        }
        return result;
    }
}
