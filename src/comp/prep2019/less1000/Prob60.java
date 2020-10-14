package comp.prep2019.less1000;
import java.util.*;
public class Prob60 {
	public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) list.add(i);
        int[] fact = new int[list.size()];
        fact[0] = 1;
        for (int i = 1; i < list.size(); i++) {
        	fact[i] = i * fact[i - 1];
        }
        StringBuilder sb = new StringBuilder();
        while(list.size() > 1) {
        	int[] arr = helper(list, k, fact);
        	sb.append(list.get(arr[0]));
        	list.remove(arr[0]);
        	k -= arr[1];
        }
        sb.append(list.get(0));
        return sb.toString();
    }
	
	private int[] helper(List<Integer> list, int k, int[] fact) {
		int c = fact[list.size() - 1];
		int idx = (k / c) + (k % c == 0 ? -1 : 0);
		return new int[] {idx, idx * c};
	}
	
	public static void main(String[] args) {
		Prob60 prob = new Prob60();
		System.out.println(prob.getPermutation(3,  3));
		System.out.println(prob.getPermutation(4,  9));
		System.out.println(prob.getPermutation(3,  1));
	}
}
