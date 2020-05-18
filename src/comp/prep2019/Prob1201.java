package comp.prep2019;

public class Prob1201 {
	public int nthUglyNumber(int n, int a, int b, int c) {
		if(n < 1) return 0;
	    int factorA_last = 1;
	    int factorB_last = 1;
	    int factorC_last = 1;
	    int nextNumber = -1;
	    for(int i = 1; i <= n; i++){
	      nextNumber = Math.min(factorA_last * a, Math.min(factorB_last * b, factorC_last * c));
	      if(nextNumber == factorA_last * a){
	    	  factorA_last++;
	      }
	      if(nextNumber == factorB_last * b){
	    	  factorB_last++;
	      }
	      if(nextNumber == factorC_last * c){
	    	  factorC_last++;
	      }

	    }
	    return nextNumber;
    }
	
	public static void main(String[] args) {
		Prob1201 prob = new Prob1201();
		System.out.println(prob.nthUglyNumber(5, 2, 11, 13));
	}
}
