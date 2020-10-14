package comp.prep2019.less1000;
import java.util.*;


public class Prob399 {
	public double[] calcEquation(List<List<String>> equations, double[] values, 
			List<List<String>> queries) {
	    double[] result = new double[queries.size()];
	    Map<String, Node> nodeMap = new HashMap<>();
	    populateNodeMap(nodeMap, equations, values);
	    for (int i = 0; i < queries.size(); i++) {
	      if (!nodeMap.containsKey(queries.get(i).get(0)) 
	    		  || !nodeMap.containsKey(queries.get(i).get(1))) result[i] = -1.0d;
	      else result[i] = executeQuery(nodeMap, queries.get(i), new HashSet<>(), 
	    		  1.0);
	    }
	    return result;
	  }

	  class Node {
	    String label;
	    Map<Node, Double> map = new HashMap<>();
	    public Node(String label) {
	      this.label = label;
	    }
	  }

	  private double executeQuery(Map<String, Node> nodeMap, 
			  List<String> query, Set<String> explored, double currentValue){
	    if (query.get(0).equals(query.get(1))) {
	      explored.add(query.get(0));
	      return currentValue;
	    }
	    explored.add(query.get(1));
	    for (Node node : nodeMap.get(query.get(1)).map.keySet()) {
	      if (explored.contains(node.label)) continue;
	      double result = executeQuery(nodeMap, Arrays.asList(query.get(0), 
	    		  node.label), explored,
	          currentValue * nodeMap.get(query.get(1)).map.get(node));
	      if (result != -1) return result;
	    }
	    return -1.0d;
	  }

	  private void populateNodeMap(Map<String, Node> nodeMap, 
			  List<List<String>> equations, double[] values){
	    for (int i = 0; i < equations.size(); i++) {
	      if (!nodeMap.containsKey(equations.get(i).get(0))) 
	    	  nodeMap.put(equations.get(i).get(0), 
	    			  new Node(equations.get(i).get(0)));
	      if (!nodeMap.containsKey(equations.get(i).get(1))) 
	    	  nodeMap.put(equations.get(i).get(1), 
	    			  new Node(equations.get(i).get(1)));
	      Node first = nodeMap.get(equations.get(i).get(0));
	      Node second = nodeMap.get(equations.get(i).get(1));
	      second.map.put(first, values[i]);
	      first.map.put(second, 1.0d /values[i]);
	    }
	  }
}
