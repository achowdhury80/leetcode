package comp.prep2019;
import java.util.*;
public class Prob752 {
	/**
	 * try all combinations using queue
	 * avoid deadends
	 * @param deadends
	 * @param target
	 * @return
	 */
	public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        for (String s : deadends) visited.add(s);
        String start = "0000";
        if (visited.contains(start)) return -1;
        if (start.equals(target)) return 0;
        // map to contain next number for a number. There will be two next.
        // e.g 1-> 2, 9  ||| 8 -> 7, 9
        Map<Character, char[]> map = new HashMap<>();
        populate(map);
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        int result = 0;
        while(!q.isEmpty()) {
        	result++;
        	int size = q.size();
        	for (int i = 0; i < size; i++) {
        		String cur = q.poll();
        		List<String> nexts = nextCombination(cur.toCharArray(), map);
        		for(String next : nexts) {
        			if (target.equals(next)) return result;
        			if (visited.add(next)) {
        				q.offer(next);
        			}
        		}
        	}
        }
        return -1;
    }
	
	private void populate(Map<Character, char[]> map) {
		for (int i = 0; i < 10; i++) {
			map.put((char)(i + '0'), new char[] {
					(char)((i + 1) % 10 + '0'), (char)((i + 9) % 10 + '0')
				});
		}
	}
	
	private List<String> nextCombination(char[] arr, Map<Character, char[]> map) {
		List<String> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			char[] nexts = map.get(c);
			arr[i] = nexts[0];
			list.add(new String(arr));
			arr[i] = nexts[1];
			list.add(new String(arr));
			arr[i] = c;
		}
		return list;
	}
}
