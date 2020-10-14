package comp.prep2019.less2000;

public class Prob1362 {
	/**
	 * O(sqrt(num))
	 * @param num
	 * @return
	 */
	public int[] closestDivisors(int num) {
        int a = 0, b = 0, c = 0, d = 0;
        for (int i = (int)Math.sqrt(num + 1); i > 0; i--) {
        	if ((num + 1) % i == 0) {
        		a = i;
        		b = (num + 1) / i;
        		break;
        	}
        }
        for (int i = (int)Math.sqrt(num + 2); i > 0; i--) {
        	if ((num + 2) % i == 0) {
        		c = i;
        		d = (num + 2) / i;
        		break;
        	}
        }
        if (Math.abs(a - b) < Math.abs(c - d)) return new int[] {a, b};
        return new int[] {c, d};
    }
	
	public static void main(String[] args) {
		Prob1362 prob = new Prob1362();
		System.out.println(prob.closestDivisors(8));
	}
}
