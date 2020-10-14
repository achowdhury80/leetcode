package comp.prep2019.less2000;
import java.util.*;
public class Prob1452 {
	public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
        	for (String s : favoriteCompanies.get(i)) {
        		Set<Integer> set = map.getOrDefault(s, new HashSet<>());
        		set.add(i);
        		map.put(s, set);
        	}
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
        	Set<Integer> set = new HashSet<>(map.get(favoriteCompanies.get(i).get(0)));
        	for (int j = 1; j < favoriteCompanies.get(i).size() && set.size() > 1; j++) {
        		set.retainAll(map.get(favoriteCompanies.get(i).get(j)));
        	}
        	if (set.size() == 1) result.add(i);
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob1452 prob = new Prob1452();
		System.out.println(prob.peopleIndexes(Arrays.asList(
				Arrays.asList("leetcode","google","facebook"),
				Arrays.asList("google","microsoft"),
				Arrays.asList("google","facebook"),
				Arrays.asList("google"),
				Arrays.asList("amazon"))));
	}
}
