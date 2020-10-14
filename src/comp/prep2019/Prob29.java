package comp.prep2019;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Prob29 {
	public int divide(int dividend, int divisor) {
		// Special cases: overflow.
	    if (dividend == Integer.MIN_VALUE && divisor == -1) {
	        return Integer.MAX_VALUE;
	    }
	    if (dividend == Integer.MIN_VALUE && divisor == 1) {
	        return Integer.MIN_VALUE;
	    }
	    
		if(dividend == 0) return 0;
		int sign = 1;
		if (dividend > 0 && divisor < 0 || dividend < 0 && divisor > 0) sign = -1;
		long x = Math.abs((long)dividend);
		long y = Math.abs((long)divisor); 
		int result = 0;
		int power = 32;
		long yPower = (long)y << 32;
		while(x >= y) {
			while(yPower > x) {
				yPower >>= 1;
				power--;
			}
			result += 1 << power;
			x -= yPower;
		}
		return sign * result;
    }
}
