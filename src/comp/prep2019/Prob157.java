package comp.prep2019;

public class Prob157 {
	public int read(char[] buf, int n) {
	    if (n == 0) return 0;
	    boolean eof = false;
	    int result = 0;
	    char[] temp = new char[4];
	    while (!eof && result < n){
	      int count = read4(temp);
	      if (count < 4) eof = true;
	      if (result + count > n) count = n - result;
	      for (int i = 0; i < count; i++) {
	        buf[result++] = temp[i];
	      }
	    }
	    return result;
	  }
	
	//dummy
	  private int read4(char[] buf) {
	    return 0;
	  }
}
