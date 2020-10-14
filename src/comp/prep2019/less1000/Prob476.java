package comp.prep2019.less1000;

public class Prob476 {
	public int findComplement(int num) {
		int temp = num;
		int mask = 0;
        while(temp > 0) {
        	mask = (mask << 1) | 1;
        	temp >>= 1;
        }
        return num ^ mask;
    }
}
