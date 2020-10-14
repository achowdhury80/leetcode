package comp.prep2019;
import java.util.*;
public class Prob1238 {
	public List<Integer> circularPermutation(int n, int start) {
		List<Integer> grayList = new ArrayList<>();
		grayList.add(0);
		grayList.add(1);
		for (int i = 1; i < n; i++) {
			List<Integer> temp = new ArrayList<>(grayList);
			for (int j = grayList.size() - 1; j > -1; j--) {
				temp.add(grayList.get(j) | (1 << i));
			}
			grayList = temp;
		}
		while(grayList.get(0) != start) grayList.add(grayList.remove(0));
		return grayList;
	}
	
	public static void main(String[] args) {
		Prob1238 prob = new Prob1238();
		System.out.println(prob.circularPermutation(2, 3));
	}
}
