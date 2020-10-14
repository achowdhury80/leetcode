package comp.prep2019.less1000;

public class Prob693 {
	public boolean hasAlternatingBits(int n) {
        int last = n & 1;
        n >>= 1;
        while(n > 0) {
        	if ((n & 1) != last) {
        		last = n & 1;
        		n >>= 1;
        	} else return false;
        }
        return true;
    }
}
