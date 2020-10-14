package comp.prep2019.less2000;

public class Prob1323 {
	/**
	 * O(logn)
	 * @param num
	 * @return
	 */
	public int maximum69Number (int num) {
        int msb = (int)Math.pow(10, ((int) Math.log10(num)));
        int result = 0;
        boolean changed = false;
        while(num > 0) {
        	int n = num / msb;
        	if (!changed && n == 6) {
        		result = result * 10 + 9;
        		changed = true;
        	} else result = result * 10 + n;
        	num %= msb;
        	msb /= 10;
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1323 prob = new Prob1323();
		System.out.println(prob.maximum69Number(9669));
	}
}
