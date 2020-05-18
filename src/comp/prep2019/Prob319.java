package comp.prep2019;

public class Prob319 {
	public int bulbSwitch(int n) {
		int result = 0;
       for (int i = 1; i * i <= n; i++) {
    	   result++;
       }
       return result;
    }
}
