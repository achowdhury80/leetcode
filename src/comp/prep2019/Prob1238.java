package comp.prep2019;
import java.util.*;
public class Prob1238 {
	public List<Integer> circularPermutation(int n, int start) {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        int val = 1;
        for (int i = 1; i <= n; i++) {
        	List<Integer> l1 = new ArrayList<>(), l2 = new ArrayList<>();
        	for (Integer j : result) {
        		l1.add(j);
        		l2.add(0, val + j);
        	}
        	l1.addAll(l2);
        	result = l1;
        	val *= 2;
        }
        while (result.get(0) != start) {
        	int last = result.remove(result.size() - 1);
        	result.add(0, last);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1238 prob = new Prob1238();
		System.out.println(prob.circularPermutation(2, 3));
	}
}
