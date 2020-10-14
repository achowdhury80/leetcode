package comp.prep2019.less1000;

public class Prob397 {
	public int integerReplacement(int n) {
        int result = 0;
        while(n != 1) {
        	// if n is even, set n = (n / 2)
        	if ((n & 1) == 0) n >>>= 1;
        	// if n == 3 or last two bits is 01 set n = n -1
        	else if (n == 3 || ((n >> 1) & 1) == 0) n--;
        	// set n to n + 1
        	else n++;
        	result++;
        }
        return result;
    }
}
