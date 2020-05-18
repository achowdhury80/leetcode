package comp.prep2019;
import java.util.*;
public class Prob898 {
	/**
	 * maintain a set of ORed number
	 * @param A
	 * @return
	 */
	public int subarrayBitwiseORs(int[] A) {
        Set<Integer> set = new HashSet<>();
        // temp1 is a set of numbers which is ORed subarray with last number
        Set<Integer> temp1 = new HashSet<>();
        for (int a : A) {
        	Set<Integer> temp2 = new HashSet<>();
        	for (int b : temp1) {
        		temp2.add(b | a);
        	}
        	temp2.add(a);
        	set.addAll(temp2);
        	temp1 = temp2;
        }
        return set.size();
    }
	
	public static void main(String[] args) {
		Prob898 prob = new Prob898();
		System.out.println(prob.subarrayBitwiseORs(new int[] {1, 1, 2}));
		System.out.println(prob.subarrayBitwiseORs(new int[] {1, 2, 4}));
	}
}
