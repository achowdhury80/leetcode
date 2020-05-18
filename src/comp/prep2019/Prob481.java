package comp.prep2019;

public class Prob481 {
	/**
	 * O(n)
	 * @param n
	 * @return
	 */
	public int magicalString(int n) {
        if (n < 1) return 0;
        if (n < 4) return 1;
        StringBuilder s1 = new StringBuilder("122"), s2 = new StringBuilder("122");
        int count = 1, l1 = 2, l2 = 2;
        int c = 0;
        while(s1.length() < n) {
        	if (l2 == s2.length()) update(s2, s1, l1++);
        	c = update(s1, s2, l2++);
        	count += c;
        }
        // if last addition adds two 1 s and make the length go beyond n
        if (s1.length() > n && c == 2) count--;
        return count;
    }
	
	/**
	 * updates a based on b at index idx
	 * @param a
	 * @param b
	 * @param idx
	 */
	private int update(StringBuilder a, StringBuilder b, int idx) {
		if (b.charAt(idx) == '1') {
    		if (a.charAt(a.length() - 1) == '2') {
    			a.append("1");
    			return 1;
    		}
    		else {
    			a.append("2");
    			return 0;
    		}
    	} else {
    		if (a.charAt(a.length() - 1) == '2') {
    			a.append("11");
    			return 2;
    		}
    		else {
    			a.append("22");
    			return 0;
    		}
    	}
	}
	
	public static void main(String[] args) {
		Prob481 prob = new Prob481();
		System.out.println(prob.magicalString(4));
	}
}
