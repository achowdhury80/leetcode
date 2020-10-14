package comp.prep2019.less2000;
import java.util.*;
public class Prob1202 {
	public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
		int n;
		if((n = pairs.size()) < 1) return s;
        int[] parent = new int[s.length()];
        for (int i = 0; i < s.length(); i++) parent[i] = i;
        for (List<Integer> pair : pairs) {
        	int parent1 = findParent(parent, pair.get(0));
        	int parent2 = findParent(parent, pair.get(1));
        	if (parent1 != parent2) {
        		if (parent1 < parent2) parent[parent2] = parent1;
        		else parent[parent1] = parent2;
        	}
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
        	int p = findParent(parent, i);
        	List<Integer> list = map.getOrDefault(p, new ArrayList<>());
        	list.add(i);
        	map.put(p, list);
        }
        
        char[] arr = s.toCharArray();
        for (int p : map.keySet()) {
        	List<Integer> list = map.get(p);
        	if (list.size() < 2) continue;
        	char[] temp = new char[list.size()];
        	for (int i = 0; i < temp.length; i++) temp[i] = arr[list.get(i)];
        	Arrays.sort(temp);
        	Collections.sort(list);
        	for (int i = 0; i < temp.length; i++) arr[list.get(i)] = temp[i];
        }
        return new String(arr);
    }
	
	private int findParent(int[] parent, int i) {
		while(i != parent[i]) i = parent[i];
		return i;
	}
	
	public static void main(String[] args) {
		Prob1202 prob = new Prob1202();
		List<List<Integer>> pairs = new ArrayList<>();
		pairs.add(Arrays.asList(new Integer[] {0, 3}));
		pairs.add(Arrays.asList(new Integer[] {1, 2}));
		System.out.println(prob.smallestStringWithSwaps("dcab", pairs));
	}
}
