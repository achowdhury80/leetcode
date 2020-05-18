package comp.prep2019;
import java.util.*;
public class Prob311 {
	public int[][] multiply(int[][] A, int[][] B) {
	    List<Integer>[] indexA = new List[A.length];
	    for (int i = 0; i < A.length; i++) {
	      indexA[i] = new ArrayList<>();
	      for (int j = 0; j < A[0].length; j++) {
	        if (A[i][j] != 0) {
	          indexA[i].add(j);
	        }
	      }
	    }

	    int[][] result = new int[A.length][B[0].length];
	    for (int i = 0; i < A.length; i++) {
	      List<Integer> list = indexA[i];
	      if (list.isEmpty()) continue;
	      for (int j = 0; j < B[0].length; j++) {
	        for (int k : list) {
	          result[i][j] += A[i][k] * B[k][j];
	        }
	      }
	    }

	    return result;
	  }
}
