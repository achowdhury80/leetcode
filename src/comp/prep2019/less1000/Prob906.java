package comp.prep2019.less1000;

public class Prob906 {
	public int superpalindromesInRange(String L, String R) {
        long l = Long.parseLong(L);
        long r = Long.parseLong(R);
        int magic = 100000, result = 0;
        
        //count odd length
        for (int k = 1; k < magic; k++) {
        	StringBuilder sb = new StringBuilder("" + k);
        	for (int i = sb.length() - 2; i > -1; i--) {
        		sb.append(sb.charAt(i));
        	}
        	long val = Long.parseLong(sb.toString());
        	val *= val;
        	if (val > r) break;
        	if (val >= l && isPalindrome(val)) result++;
        }
        
        //count event length
        for (int k = 1; k < magic; k++) {
        	StringBuilder sb = new StringBuilder("" + k);
        	for (int i = sb.length() - 1; i > -1; i--) {
        		sb.append(sb.charAt(i));
        	}
        	long val = Long.parseLong(sb.toString());
        	val *= val;
        	if (val > r) break;
        	if (val >= l && isPalindrome(val)) result++;
        }
        
        return result;
    }
	
	private boolean isPalindrome(long x) {
		return x == reverse(x);
	}
	
	private long reverse(long n) {
		long ans = 0;
		while(n > 0) {
			ans = ans * 10 + n % 10;
			n /= 10;
		}
		return ans;
	}
	
	public static void main(String[] args) {
		Prob906 prob = new Prob906();
		System.out.println(prob.superpalindromesInRange("4", "1000"));
		
	}
}
