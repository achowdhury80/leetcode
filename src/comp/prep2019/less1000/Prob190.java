package comp.prep2019.less1000;

public class Prob190 {
	/**
	 * O(1) 
	 * @param n
	 * @return
	 */
	public int reverseBits(int n) {
        Long result = 0l;
        for (int i = 0; i < 32; i++) {
        	result = (result << 1);
        	result |= (n & 1);
            n = (n >> 1);
        }
        return result.intValue();
    }
}
