package comp.prep2019.less1000;

public class Prob978 {
	public int maxTurbulenceSize(int[] A) {
        if (A.length < 2) return A.length;
        int increase = 1, decrease = 1, result = 1;
        for (int i = 1; i < A.length; i++) {
        	if (A[i] == A[i - 1]) {
        		increase = 1;
        		decrease = 1;
        	} else if (A[i] > A[i - 1]) {
        		increase = decrease + 1;
        		decrease = 1;
        		result = Math.max(result, increase);
        	} else {
        		decrease = increase + 1;
        		increase = 1;
        		result = Math.max(result, decrease);
        	}
        }
        return result;
	}
	//O(n)
		//three cases - equal, less than greater than
		// at each element keep track of turbolant count, and last change(0 - equal, 1 - higher, -1 lower
		public int maxTurbulenceSize1(int[] A) {
	        if (A.length < 2) return A.length;
	        int last = 0, count = 1;
	        int result = 1;
	        for (int i = 1; i < A.length; i++) {
	        	if (A[i] == A[i - 1]) {
	        		count = 1;
	        		last = 0;
	        	} else if (A[i] > A[i - 1]) {
	        		if (last < 0) {
	        			count++;
	        		} else {
	        			count = 2;
	        		} 
	        		last = 1;
	        	} else {
	        		if (last > 0) {
	        			count++;
	        		} else {
	        			count = 2;
	        		} 
	        		last = -1;
	        	}
	        	result = Math.max(result, count);
	        }
	        return result;
	    }
	
	public static void main(String[] args) {
		Prob978 prob = new Prob978();
		System.out.println(prob.maxTurbulenceSize(new int[] {9,4,2,10,7,8,8,1,9}));
	}
}
