package comp.prep2019;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class Prob1203 {
	public int[] sortItems(int n, int m, int[] group, 
			List<List<Integer>> beforeItems) {
       Map<Integer, List<Integer>> groups = new HashMap<>();
       Map<Integer, Set<Integer>> nextNodeMap = new HashMap<>();
       int[] indegree = new int[n];
       
       for (int i = 0; i < n; i++) {
    	   List<Integer> list = groups.getOrDefault(group[i], new ArrayList<>());
    	   list.add(i);
    	   groups.put(group[i], list);
    	   List<Integer> beforeItem = beforeItems.get(i);
    	   for (int j : beforeItem) {
    		   Set<Integer> nexts 
    		   	= nextNodeMap.getOrDefault(j, new HashSet<>());
    		   nexts.add(i);
    		   nextNodeMap.put(j, nexts);
    		   indegree[i]++;
    	   }
       }
       // order each group item
       Map<Integer, List<Integer>> temp = new HashMap<>();
       for (int groupId : groups.keySet()) {
    	   List<Integer> groupItems = sort(nextNodeMap, new HashSet<>(
    			   groups.get(groupId)));
    	   if (groupItems == null) return new int[0];
    	   temp.put(groupId, groupItems);
       }
       groups = temp;
       Map<Integer, Set<Integer>> nextGroupMap = new HashMap<>();
       for (int groupId : groups.keySet()) {
    	   List<Integer> items = groups.get(groupId);
    	   for (int item : items) {
    		   Set<Integer> nextNodes = nextNodeMap.get(item);
    		   if (nextNodes == null) continue;
    		   for (int next : nextNodes) {
	    		   int nextGroup = group[next];
	    		   if (nextGroup != groupId) {
	    			   Set<Integer> nextGroups = nextGroupMap.getOrDefault(groupId, 
	    					   new HashSet<>());
	    			   nextGroups.add(nextGroup);
	    			   nextGroupMap.put(groupId, nextGroups);
	    		   }
    		   }
    	   }
       }
       List<Integer> sortedGroups = sort(nextGroupMap, groups.keySet());
       if (sortedGroups == null) return new int[0];
       int[] result = new int[n];
       int idx = 0;
       for (int g : sortedGroups) {
    	   for (int item : groups.get(g)) {
    		   result[idx++] = item;
    	   }
       }
       return result;
    }
	
	private List<Integer> sort(Map<Integer, Set<Integer>> nextMap, Set<Integer> items) {
		Map<Integer, Integer> indeg = new HashMap<>();
		for (int item : items) {
			Set<Integer> nexts = nextMap.get(item);
			if (nexts == null) continue;
			for (int next : nexts) {
				if (items.contains(next)) {
					indeg.put(next, indeg.getOrDefault(next, 0) + 1);
				}
			}
		}
		Queue<Integer> q = new LinkedList<>();
		for (int item : items) {
			if (!indeg.containsKey(item)) q.offer(item);
		}
		List<Integer> result = new ArrayList<>();
		while(!q.isEmpty()) {
			int item = q.poll();
			result.add(item);
			Set<Integer> nexts = nextMap.get(item);
			if (nexts == null) continue;
			for (int next : nexts) {
				if (items.contains(next)) {
					indeg.put(next, indeg.get(next) - 1);
					if (indeg.get(next) == 0) q.offer(next);
				}
			}
		}
		return result.size() == items.size() ? result : null;
	}
	
	public static void main(String[] args) {
		Prob1203 prob = new Prob1203();
		List<List<Integer>> list = new ArrayList<>();
		list.add(IntStream.of(new int[] {}).boxed().collect(Collectors.toList()));
		list.add(IntStream.of(new int[] {6}).boxed().collect(Collectors.toList()));
		list.add(IntStream.of(new int[] {5}).boxed().collect(Collectors.toList()));
		list.add(IntStream.of(new int[] {6}).boxed().collect(Collectors.toList()));
		list.add(IntStream.of(new int[] {3, 6}).boxed().collect(Collectors.toList()));
		list.add(IntStream.of(new int[] {}).boxed().collect(Collectors.toList()));
		list.add(IntStream.of(new int[] {}).boxed().collect(Collectors.toList()));
		list.add(IntStream.of(new int[] {}).boxed().collect(Collectors.toList()));
		int[] result = prob.sortItems(8, 2, new int[] {-1,-1,1,0,0,1,0,-1},
               list);
         for (int i : result) {
        	 System.out.print(i + ", ");
         }
	}
}
