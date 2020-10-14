package comp.prep2019.less1000;

public class Prob696 {
	/**
	 * O(N) time and O(1) space
	 * keep track of 0 and 1 count
	 * cur is 0 or 1
	 * if there is a change in cur, add min of 0 and 1 count to result
	 * set cur count to 1
	 * @param s
	 * @return
	 */
	public int countBinarySubstrings(String s) {
        int result = 0;
        int[] count = new int[2];
        int cur = s.charAt(0) - '0';
        count[cur]++;
        for (int i = 1; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if (c - '0' == cur) count[cur]++;
        	else {
        		result += Math.min(count[0], count[1]);
        		cur = c - '0';
        		count[cur] = 1;
        	}
        }
        result += Math.min(count[0], count[1]);
        return result;
    }
	
	public static void main(String[] args) {
		Prob696 prob = new Prob696();
		System.out.println(prob.countBinarySubstrings("100111001"));
	}
}
