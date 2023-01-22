package com.prep2020.medium;
import java.util.*;
public class Problem399 {
	public double[] calcEquation(List<List<String>> equations, double[] values, 
			List<List<String>> queries) {
	    Map<String, Map<String, Double>> map = new HashMap<>();
	    Set<String> set = new HashSet<>();
	    for (int i = 0; i < equations.size(); i++) {
	    	List<String> eqn = equations.get(i);
	    	Map<String, Double> valMap = map.getOrDefault(eqn.get(0), 
	    			new HashMap<>());
	    	valMap.put(eqn.get(1), values[i]);
	    	valMap.put(eqn.get(0), 1.0);
	    	map.put(eqn.get(0), valMap);
	    	valMap = map.getOrDefault(eqn.get(1), 
	    			new HashMap<>());
	    	valMap.put(eqn.get(0), 1 / values[i]);
	    	valMap.put(eqn.get(1), 1.0);
	    	map.put(eqn.get(1), valMap);
	    	set.add(eqn.get(0));
	    	set.add(eqn.get(1));
	    }
	    List<String> vars = new ArrayList<>(set);
	    for (int k = 0; k < vars.size(); k++) {
	    	for (int i = 0; i < vars.size(); i++) {
	    		for (int j = 0; j < vars.size(); j++) {
	    			Map<String, Double> valMap = map.get(vars.get(i));
	    			if (valMap.containsKey(vars.get(k)) && map.get(vars.get(k)).containsKey(vars.get(j)))
	    				valMap.put(vars.get(j), map.get(vars.get(i)).get(vars.get(k)) * 
	    					map.get(vars.get(k)).get(vars.get(j)));
	    		}
	    	}
	    }
	    double[] result = new double[queries.size()];
	    int idx = -1;
	    for (List<String> q : queries) {
	    	idx++;
	    	if (!map.containsKey(q.get(0)) || !map.get(q.get(0)).containsKey(q.get(1))) {
	    		result[idx] = -1;
	    	} else {
	    		result[idx] = map.get(q.get(0)).get(q.get(1));
	    	}
	    }
	    return result;
	}
	
	public static void main(String[] args) {
		Problem399 problem = new Problem399();
		System.out.println(problem.calcEquation(Arrays.asList(Arrays.asList("a", "b"), 
				Arrays.asList("b", "c")), new double[] {2.0, 3.0}, 
				Arrays.asList(Arrays.asList("a", "c"))));
	}
}
