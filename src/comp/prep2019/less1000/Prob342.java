package comp.prep2019.less1000;

public class Prob342 {
	public boolean isPowerOfFour(int num) {
		int count = Integer.bitCount(num);
		if (count != 1) return false;
		if (num == 1) return true;
		int i = 2;
		while(num > 0) {
			num = num >> i;
			if ((num & 1) == 1) return true;
		}
	    return false;  
    }
	
	public static void main(String[] args) {
		Prob342 prob = new Prob342();
		System.out.println(prob.isPowerOfFour(16));
	}
}
