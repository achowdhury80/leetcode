package comp.prep2019;
import java.util.*;
public class Prob1428 {
	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dim = binaryMatrix.dimensions();
		int result = -1, end = dim.get(1) - 1;
		for (int i = 0; i < dim.get(0); i++) {
			int idx = find(end, i, binaryMatrix);
			if (idx != -1) {
				result = idx;
				end = idx - 1;
				if (result == 0) return 0;
			}
		}
		return result;
    }
	
	private int find(int end, int row, BinaryMatrix binaryMatrix) {
		int start = 0;
		int result = -1;
		while(end - start > 1) {
			int mid = start + (end -start) / 2;
			int val = binaryMatrix.get(row, mid);
			if (val == 0) start = mid + 1;
			else {
				end = mid - 1;
				result = mid;
			}
		}
		if (binaryMatrix.get(row, start) == 1) return start;
		if (start != end && binaryMatrix.get(row, end) == 1) return end;
		return result;
	}
	
	interface BinaryMatrix {
		      public int get(int row, int col);
		     public List<Integer> dimensions();
		  }
}
