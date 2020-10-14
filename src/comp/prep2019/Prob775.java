package comp.prep2019;
import java.util.*;
public class Prob775 {
	/**
	 * local inversion is also global inversion
	 * we need to find if there is any non-local inversion
	 * https://leetcode.com/problems/global-and-local-inversions/solution/
	 * @param A
	 * @return
	 */
	public boolean isIdealPermutation(int[] A) {
	    int max = A[0];
	    for(int i = 2; i < A.length; i++){
	      if(max > A[i]) return false;
	      else max = Math.max(max, A[i - 1]);
	    }
	    return true;
	  }
	    /*public boolean isIdealPermutation(int[] A) {
			if (A.length < 3) return true;
	        Set<Integer> set = new HashSet<>(), notIncluded = new HashSet<>();
	        int localInversion = 0, globalInversion = 0;
	        
	        for (int i = A.length - 1; i > 0; i--) {
	        	if (A[i] < A[i - 1]) {
	        		localInversion++;
	        	} 
	        	if (A.length - 1 - A[i] - set.size() > 0)
	        		globalInversion += (A.length - 1 - A[i] - set.size());
	        	if (notIncluded.contains(i)) {
	        		set.add(i);
	        		notIncluded.remove(i);
	        	}
	        	if (A[i] >= i) {
	        		set.add(A[i]);
	        	} else notIncluded.add(A[i]);
	        }
	        return localInversion == globalInversion;
	    }*/
	
	public static void main(String[] args) {
		Prob775 prob = new Prob775();
		System.out.println(prob.isIdealPermutation(new int[] {0, 3, 2, 1}));
	}
}
