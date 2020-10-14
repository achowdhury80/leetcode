package comp.prep2019.less1000;
import java.util.*;
public class Prob690 {
	/**
	 * O(N) time and space
	 * @param employees
	 * @param id
	 * @return
	 */
	public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
        	map.put(e.id, e);
        }
        return helper(map.get(id), map);
    }
	
	private int helper(Employee e, Map<Integer, Employee> map) {
		int result = e.importance;
		if (e.subordinates != null) {
			for (int sub : e.subordinates) {
				result += helper(map.get(sub), map);
			}
			
		}
		return result;
	}
	
	class Employee {
	    // It's the unique id of each node;
	    // unique id of this employee
	    public int id;
	    // the importance value of this employee
	    public int importance;
	    // the id of direct subordinates
	    public List<Integer> subordinates;
	}
}
