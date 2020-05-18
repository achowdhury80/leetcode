package comp.prep2019;

public class Prob372 {
	public int superPow(int a, int[] b) {
	    if(a == 0 || a == 1) return a % 1337;
	    if(b.length == 1 && b[0] == 0) return 1;
	    if(b.length == 1 && b[0] == 1) return a % 1337;
	    return superPow(a, b, b.length - 1);
	  }

	  public int superPow(int a, int[] b, int end) {
	    if(end > 0){
	      if(b[end] == 0){
	        return powerMod(superPow(a, b, end - 1), 10);
	      } else{
	        return (powerMod(superPow(a, b, end - 1), 10) * powerMod(a, b[end])) % 1337;
	      }
	    }
	    return powerMod(a, b[end]);
	  }

	  private int powerMod(int a, int k){
	    a = a % 1337;
	    if(k == 0) return 1;
	    if(k == 1) return a;
	    int result = 1;
	    for(int i = 0; i < k; i++){
	      result = (result * a) % 1337;
	    }
	    return result;
	  }
}
