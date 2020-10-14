package comp.prep2019.less1000;
import java.util.*;
public class Prob989 {
	public List<Integer> addToArrayForm(int[] A, int K) {
		List<Integer> result = new ArrayList<>();
		int carry = 0;
		for (int i = 0; i < A.length || K > 0; i++, K /= 10) {
			if (i < A.length) carry += A[A.length - i - 1];
			carry += (K % 10);
			result.add(0, carry % 10);
			carry /= 10;
		}
		if (carry > 0) result.add(0, carry);
		return result;
    }
}
