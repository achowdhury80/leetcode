package comp.prep2019.less1000;

public class Prob400 {
	public int findNthDigit(int n) {
	    int len = 1;
	    long count = 9;
	    int start = 1;
	    while(n > len * count){
	      n -= len * count;
	      len++;
	      count *= 10;
	      start *= 10;
	    }
	    start += (n - 1) / len;
	    String s = Integer.toString(start);
	    return Character.getNumericValue(s.charAt((n - 1) % len));
	  }
	
	public static void main(String[] args) {
		Prob400 prob = new Prob400();
		//System.out.println(prob.findNthDigit(11));
		System.out.println(prob.findNthDigit(1000000000));
	}
}
