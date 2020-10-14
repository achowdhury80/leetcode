package comp.prep2019.less1000;
import java.util.*;
public class Prob465 {
	/*
	 * inspired from 
	 * https://leetcode.com/problems/optimal-account-balancing/discuss/509994/91.92-and-76.92-JAVA-Solution-and-Analysis
	 */
	public int minTransfers(int[][] transactions) {
        Map<Integer, Integer> map = new HashMap<>();
        // maintain a map of non zero balance for people
        for (int[] tran : transactions) {
        	map.put(tran[0], map.getOrDefault(tran[0], 0) - tran[2]);
        	map.put(tran[1], map.getOrDefault(tran[1], 0) + tran[2]);
        	if (map.get(tran[0]) == 0) map.remove(tran[0]);
        	if (map.get(tran[1]) == 0) map.remove(tran[1]);
        }
        List<Integer> people = new ArrayList<>(map.keySet());
        int group = 0;
        while(!people.isEmpty()) {
        	// find smallest group whose balance is zero taking first person as 
        	//member of the group
        	List<Integer> groupMembers = helper(people, map);
        	group++;
        	people.removeAll(groupMembers);
        }
        return map.size() - group;
    }
	
	private List<Integer> helper(List<Integer> people, 
			Map<Integer, Integer> map) {
		boolean[] used = new boolean[people.size()];
		// q for bfs
		Queue<Node> q = new LinkedList<>();
		// take the first member as part of the group
		q.offer(new Node(0, used, map.get(people.get(0))));
		used[0] = true;
		while(!q.isEmpty()) {
			int size = q.size();
			for (int i = 0; i < size; i++) {
				Node cur = q.poll();
				// try all people one at a time
				for (int j = cur.last + 1; j < people.size(); j++) {
					boolean[] arr = Arrays.copyOf(cur.used, cur.used.length);
					arr[j] = true;
					int bal = cur.bal + map.get(people.get(j));
					if (bal == 0) {
						List<Integer> result = new ArrayList<>();
						for (int k = 0; k < arr.length; k++) {
							if (arr[k]) {
								result.add(people.get(k));
							}
						}
						return result;
					} else {
						q.offer(new Node(j, arr, bal));
					}
				}
			}
		}
		return null;
		
	}
	
	class Node {
		int last = -1;
		boolean[] used;
		int bal = 0;
		Node(int last, boolean[] used, int bal) {
			this.last = last;
			this.used = used;
			this.bal = bal;
		}
	}
	
	public static void main(String[] args) {
		Prob465 prob = new Prob465();
		System.out.println(prob.minTransfers(new int[][] {{10,11,6},{12,13,7},
			{14,15,2},{14,16,2},{14,17,2},{14,18,2}}));
	}
}
