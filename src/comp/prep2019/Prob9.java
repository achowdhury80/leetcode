package comp.prep2019;

public class Prob9 {
	public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int rev = 0;
        int y = x;
        while(y > 0) {
        	int rem = y % 10;
        	int temp = rev * 10 + rem;
        	if ((temp - rem) / 10 != rev) return false;
        	rev = temp;
        	y /= 10;
        }
        return x == rev;
    }
}
