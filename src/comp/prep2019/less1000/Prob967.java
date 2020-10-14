package comp.prep2019.less1000;
import java.util.*;
public class Prob967 {
	public int[] numsSameConsecDiff(int N, int K) {
        if (N == 1) {
        	int[] arr = new int[10];
        	for (int i = 0; i < 10; i++) arr[i] = i;
        	return arr;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) list.add(i);
        List<Integer> r = helper(list, N - 1, K);
        int[] result = new int[r.size()];
        for (int i = 0; i < r.size(); i++) result[i] = r.get(i);
        return result;
    }
	
	private List<Integer> helper(List<Integer> list, int n, int k) {
		if (n == 0) return list;
		List<Integer> temp = new ArrayList<>();
		for (int i : list) {
			int last = i % 10;
			if (last + k < 10) temp.add(i * 10 + last + k);
			if (k != 0 && last - k > -1) temp.add(i * 10 + last - k);
		}
		return helper(temp, n - 1, k);
	}
}
