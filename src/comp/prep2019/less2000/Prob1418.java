package comp.prep2019.less2000;
import java.util.*;
public class Prob1418 {
	public List<List<String>> displayTable(List<List<String>> orders) {
        Set<String> foods = new HashSet<>();
        Map<Integer, Map<String, Integer>> map = new HashMap<>();
        for (List<String> order : orders) {
        	foods.add(order.get(2));
        	int table = Integer.parseInt(order.get(1));
        	Map<String, Integer> foodCount 
        		= map.getOrDefault(table, new HashMap<>());
        	foodCount.put(order.get(2), foodCount.getOrDefault(order.get(2), 0) + 1);
        	map.put(table, foodCount);
        }
        List<String> foodList = new ArrayList<>(foods);
        Collections.sort(foodList);
        List<Integer> tables = new ArrayList<>(map.keySet());
        Collections.sort(tables);
        List<List<String>> result = new ArrayList<>();
        List<String> header = new ArrayList<>();
        header.add("Table");
        for (String s : foodList) header.add(s);
        result.add(header);
        for (int table : tables) {
        	List<String> list = new ArrayList<>();
        	list.add("" + table);
        	for (String food : foodList) {
        		if (!map.get(table).containsKey(food)) list.add("0");
        		else list.add("" + map.get(table).get(food));
        	}
        	result.add(list);
        }
        return result;
    }
}
