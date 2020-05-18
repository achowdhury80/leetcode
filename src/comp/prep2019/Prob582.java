package comp.prep2019;
import java.util.*;
public class Prob582 {
	public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
        	List<Integer> children = map.getOrDefault(ppid.get(i), new ArrayList<>());
        	children.add(pid.get(i));
        	map.put(ppid.get(i), children);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(kill);
        List<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
        	int proc = q.poll();
        	result.add(proc);
        	if (map.containsKey(proc)) {
        		for (int child : map.get(proc)) q.offer(child);
        	}
        }
        return result;
    }
	
	public static void main(String[] args) {
		Prob582 prob = new Prob582();
		System.out.println(prob.killProcess(Arrays.asList(1, 3, 10, 5), Arrays.asList(3, 0, 5, 3), 5));
	}
}
