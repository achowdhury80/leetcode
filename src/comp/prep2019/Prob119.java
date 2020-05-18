package comp.prep2019;
import java.util.*;
public class Prob119 {
	public List<Integer> getRow(int rowIndex) {
		List<Integer> list = new ArrayList<>();
		if (rowIndex < 0) return list;
		list.add(1);
		while(rowIndex > 0) {
			for (int i = list.size() - 1; i > 0; i--) {
				list.set(i, list.get(i) + list.get(i - 1));
			}
			list.add(1);
			rowIndex--;
		}
		return list;
    }
	
	public static void main(String[] args) {
		Prob119 prob = new Prob119();
		System.out.println(prob.getRow(3));
	}
}
