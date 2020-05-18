package comp.prep2019;

public class Prob1056 {
	public boolean confusingNumber(int N) {
	       int temp = 0, num = 0, n = N;
	       while(n > 0) {
	    	   temp = (n % 10); 
	    	   if (temp == 2 || temp == 3 || temp == 4 || temp == 5 || temp == 7) return false;
	    	   num *= 10;
	    	   num += (temp == 6 ? 9 : (temp == 9 ? 6 : temp));
	    	   n /= 10;
	       }
	       return num != N;
	    }
}
