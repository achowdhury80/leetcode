package comp.prep2019.less1000;

public class Prob7 {
	public int reverse(int x) {
        int rev = 0;
        while(x != 0) {
        	int tail = x % 10;
        	int temp = rev * 10 + tail;
        	if ((temp - tail)/10 != rev) return 0;
        	rev = temp;
        	x /= 10;
        }
        return rev;
    }
}
