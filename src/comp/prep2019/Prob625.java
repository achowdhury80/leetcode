package comp.prep2019;

public class Prob625 {
	public int smallestFactorization(int a) {
	    long result = 0;
	    if (a < 10) return a;
	    long multipy = 1;
	    do {
	      boolean found = false;
	      for (int i = 9; i > 1; i--) {
	        if (a % i == 0) {
	          found = true;
	          result += i * multipy;
	          multipy *= 10;
	          a = a / i;
	          break;
	        }
	      }
	      if (!found) return 0;
	    } while (a > 9);
	    result = a * multipy + result;
	    return result > Integer.MAX_VALUE ? 0 : (int) result;
	  }
}
